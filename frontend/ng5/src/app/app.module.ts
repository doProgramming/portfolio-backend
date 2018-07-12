import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { LoggerModule, Options, Level } from 'simple-angular-logger';

export function loggerOptions(): Options {
    return { level: Level.LOG };
}

@NgModule({
  declarations:[
    AppComponent
  ],
  imports:[
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    LoggerModule.forRoot(loggerOptions),
  ],
  providers:[AppComponent],
  bootstrap:[AppComponent]

})
export class AppModule { }
