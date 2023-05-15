import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../module/login';
import { User } from '../module/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient, private router: Router) { }

  isLoggedIn: boolean = false;
  logged: Login = {};

  checkLogin(login: User) {
    this.httpClient.post('http://localhost:9005/api/v1/login', login).subscribe({
      next: (data: any) => {
        console.log(data)
        this.logged = data;
        sessionStorage.setItem("token", data.token);
        console.log(data.token);
        console.log(this.logged);
        if (this.logged != null) {
          this.isLoggedIn = true;
          sessionStorage.setItem("status", <string><unknown>this.isLoggedIn);
          console.log(this.isLoggedIn)
          alert('Successfully Added');
          this.router.navigateByUrl('/vehicle')
        }
      },
      error: (error) => {
        alert("Username and Password does not match");
      }
    });

  }
  logout() {
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('status');
    this.isLoggedIn = false;
    this.router.navigateByUrl('/login'); // navigate to the login page
   
  }
  returnStatus() {
    return <boolean><unknown>sessionStorage.getItem('status');
  }
}
