import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../module/vehicle';
import { LoginService } from '../Services/login.service';
import { UserServiceService } from '../Services/user-service.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  cartList: Vehicle[] = [];

  constructor(private userService: UserServiceService, private loginUser: LoginService) {
    this.userService.getAllVehicle().subscribe({
      next: (data) => {
        this.cartList = data;
      
        console.log(data);
        
      },
      error: (error) => {
        console.log(error);
        alert("Get Failure");
      }
    });
  }

  deleteItem(vehicleId: any) {

      this.cartList=this.cartList.filter(x =>x.vehicleId!=vehicleId)
  this.userService.deletevehiclefromCart(vehicleId).subscribe(data => console.log(data));
}

  }

