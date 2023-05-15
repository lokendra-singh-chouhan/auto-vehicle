import { Component, OnChanges, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from '../Services/user-service.service';
import { HttpClient } from '@angular/common/http';
import { Vehicle } from '../module/vehicle';
import { LoginService } from '../Services/login.service';
import { AdminService } from '../Services/admin.service';
import { RouterService } from '../Services/router.service';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent {
  isMouseOver: boolean = false;
  Vehicles: any;

  constructor(private loginService: LoginService, private userService: UserServiceService, private adminService: AdminService,private routerService: RouterService) {
    this.adminService.getAllVehicles().subscribe({
      next: (data) => {
        this.Vehicles = data;
        console.log(data);
      },
      error: (error) => {
        alert(error + "error has been orrured in the network")
      }
    });
  }

  addtoCart(vehicle: Vehicle) {
    console.log(vehicle);
    this.userService.saveVehicletoCart(vehicle).subscribe({
      next: (data) => {
        console.log(data);
        if (data != null) {
          alert("Item Save To Cart");
          window.location.reload()
        }
      },
      error: (error) => {
        alert("please login first")
        this.routerService.navigateToLoginView()
      }
    });
  }
}







































