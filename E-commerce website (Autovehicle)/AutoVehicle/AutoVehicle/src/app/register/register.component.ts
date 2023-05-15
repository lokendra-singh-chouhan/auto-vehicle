import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { UserServiceService } from '../Services/user-service.service';
import { User } from '../module/user';
import { RouterService } from '../Services/router.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent{

  hide = true;
  register: FormGroup;

  user: User = {
    userName: '',
    emailId: '',
    password: ''
  };

  constructor(private formBuilder: FormBuilder, private UserService: UserServiceService, private routerService: RouterService) {
    this.register = this.formBuilder.group({
      userName: new FormControl('', [Validators.required]),
      emailId: new FormControl('', [Validators.required, Validators.pattern(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/)]),
      password: new FormControl('', [Validators.required, Validators.minLength(8)])
    });
  }

  get password() {
    return this.register.get('password');
  }

  get confirmpassword() {
    return this.register.get('confirmPassword');
  }

  onSubmit() {

    this.user = this.register.value;
    console.log(this.register);
    console.log(this.register.value);

    this.UserService.registerUser(this.user).subscribe({
      next: (data) => {
        alert("User added Successfully");
        this.routerService.navigateToLoginView();
      },
      error: (error) => {
        alert('user already exist');
      }
    });
  }


}
