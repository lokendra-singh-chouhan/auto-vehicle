import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouterService {

  constructor(private router: Router) { }

  navigateToFirstView() {
    this.router.navigate([""]);
  }

  // navigateToUserView() {
  //   this.router.navigate(["/user"]);
  // }

  navigateToAdminView() {
    this.router.navigate(["/admin"]);
  }

  navigateToHome() {
    this.router.navigate(["/vehicle"]);
  }

  navigateToLoginView(){
    this.router.navigate(["/login"]); 
  }

  navigateToRegisterView() {
    this.router.navigate(["/register"]);
  }

  navigateToCartView() {
    this.router.navigate(["/cart"]);
  }

}
