import { Component } from '@angular/core';
import { LoginService } from '../Services/login.service';
import { UserServiceService } from '../Services/user-service.service';
import { AdminService } from '../Services/admin.service';
import { RouterService } from '../Services/router.service';
import { Vehicle } from '../module/vehicle';

@Component({
  selector: 'app-adminc',
  templateUrl: './adminc.component.html',
  styleUrls: ['./adminc.component.css']
})
export class AdmincComponent {
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

  // onDelete() {
  //   this.adminService.deleteVehicle(this.deleteForm.get("vehicleId")?.value).subscribe({
  //     next: (data) => {
  //       alert("delete Successfully");
  //       window.location.reload()
  //     },
  //     error: (error) => {
  //       alert("Error");
  //     }
  //   });


  deleteById(vehicleId:string){
    this.adminService.deleteVehicle(vehicleId).subscribe({
      next: (data) => {
        alert("delete Successfully");
        window.location.reload()
      },
      error: (error) => {
        alert("Error");
      }
    });

  }

  // updateById(vehicleId:string){
  //     let updateVehicle: Vehicle = {
  //       vehicleId: this.Vehicles.vehicleId,
  //       vehicleName: this.Vehicles.vehicleName,
  //       vehicleCategory: this.Vehicles.vehicleCategory
  //     }
  //     this.adminService.updateVehicle(updateVehicle).subscribe({
  //       next: (data) => {
  //         alert("updated Successfully");
  //         window.location.reload()
  //       },
  //       error: (error) => {
  //         alert("Error");
  //       }
  //     });

  }

// }

