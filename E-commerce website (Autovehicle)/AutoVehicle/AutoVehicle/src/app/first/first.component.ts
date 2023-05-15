import { Component } from '@angular/core';
import { RouterService } from '../Services/router.service';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent {

  adminCode: string='';

  constructor(private routerService: RouterService){}

  checkCode(){
    if(this.adminCode=='admin@123'){
      this.routerService.navigateToAdminView();
    }
    else{
      alert('Please Enter Correct Code');
      this.routerService.navigateToFirstView();
    }
  }

}
