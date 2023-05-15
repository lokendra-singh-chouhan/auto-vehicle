import { Component } from '@angular/core';
import { UserServiceService } from '../Services/user-service.service';
import { Router } from '@angular/router';
import { LoginService } from '../Services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private userService: UserServiceService, private router: Router, private loginser: LoginService) {

  }
  logoutis(){
    this.loginser.logout();
      this.router.navigateByUrl("/Login")
  }


  loginguard(): boolean {
    if (this.loginser.returnStatus()) {
      // this.router.navigateByUrl('');
      return true;
    }
    else
      return false;


  }
}


