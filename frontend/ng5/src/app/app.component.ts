import {Component, Injectable, OnInit} from '@angular/core';
import {HttpClient,HttpResponse} from "@angular/common/http";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {isNull} from '@angular/compiler/src/output/output_ast';

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
      email : [null,[Validators.required,Validators.min(3)]]

    })
  }
  private apiUrl = 'http://localhost:8080/';
  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient){

    //this.getLink();
  }
  getLink(lastname,salary){
      return this.http.get(this.apiUrl)
  }

  saveLink(){
   return this.http.post(this.apiUrl+
      'save?firstname='+this.inputData.get('firstname').value+
      '&lastname='+this.inputData.get('lastname').value+'&email='+
      this.inputData.get('email').value,'test')
      .subscribe((res: HttpResponse<any>) => res.statusText)
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
