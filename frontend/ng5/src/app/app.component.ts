import {Component, Injectable, OnInit} from '@angular/core';
import {HttpClient,HttpResponse} from "@angular/common/http";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

@Injectable()
export class AppComponent implements OnInit{
  inputData : FormGroup;
  title = 'my portfolio website';
  ngOnInit(){
    this.inputData = this.formBuilder.group({
      firstname : [null,[Validators.required, Validators.maxLength(14),Validators.min(3)]],
      lastname : [null,[Validators.required, Validators.maxLength(14),Validators.min(3)]],
      email : [null,[Validators.required,Validators.min(3)]],
      username : [],
      password : []
    })
  }
  private apiUrl = 'http://localhost:8080/';
  private verifiedUser: Boolean;
  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient){
    //this.getLink();
  }

  isVerifiedUser(){}

  loginAdmin(){
    this.verifiedUser = false;
      return this.http.get(this.apiUrl+'login?username='+
        this.inputData.get('username').value+'&password='+this.inputData.get('password').value)
        .subscribe((res : HttpResponse<any>) => res.body)
  }

  getLink(lastname,salary){
      return this.http.get(this.apiUrl)
  }

  saveLink(){
   return this.http.get(this.apiUrl+
      'save?firstname='+this.inputData.get('firstname').value+
      '&lastname='+this.inputData.get('lastname').value+'&email='+
      this.inputData.get('email').value)
      .subscribe((res: HttpResponse<any>) => res.body)
  }

  isValid(){
   return this.inputData.valid
  }
  isNotNull(){
   return this.inputData.getRawValue().firstname
  }

  scroll(el) {
    el.scrollIntoView();
  }

}
