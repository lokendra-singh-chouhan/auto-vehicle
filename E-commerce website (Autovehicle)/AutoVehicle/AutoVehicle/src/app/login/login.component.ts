import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../module/user';
import { LoginService } from '../Services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent{

  loginForm: FormGroup;
  
  constructor(private formBuilder:FormBuilder, private loginService: LoginService){
    this.loginForm = this.formBuilder.group({
      emailId:new FormControl ('', [Validators.required,  Validators.pattern(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/)]),
      password: new FormControl('', [Validators.required, Validators.minLength(8)])
    });
  }

  onSubmit() {
    console.log(this.loginForm.value);
    let login:User={
      emailId: this.loginForm.get("emailId")?.value,
      password: this.loginForm.get("password")?.value,
    }
    this.loginService.checkLogin(login);
 }
}
