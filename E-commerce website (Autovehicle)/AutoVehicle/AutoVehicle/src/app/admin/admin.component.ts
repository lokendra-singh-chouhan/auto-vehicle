import { Component } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { LoginService } from '../Services/login.service';
import { AdminService } from '../Services/admin.service';
import { Vehicle } from '../module/vehicle';
import { UserServiceService } from '../Services/user-service.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {



  addForm: FormGroup;
  updateForm: FormGroup;
  deleteForm: FormGroup;


  constructor(private formBuilder: FormBuilder, private adminService: AdminService, private loginService: LoginService, private userService: UserServiceService) {



    this.addForm = this.formBuilder.group({
      vehicleId: new FormControl(),
      vehicleName: new FormControl('', [Validators.required]),
      vehicleCategory: new FormControl('', [Validators.required])
    });



    this.updateForm = this.formBuilder.group({
      vehicleId: new FormControl('', [Validators.required]),
      vehicleName: new FormControl('', [Validators.required]),
      vehicleCategory: new FormControl('', [Validators.required])
    });

    this.deleteForm = this.formBuilder.group({
      vehicleId: new FormControl('', [Validators.required])
    });
  }



  onAdd() {
    let addVehicle: Vehicle = {
      vehicleId: this.addForm.get("vehicleId")?.value,
      vehicleName: this.addForm.get("vehicleName")?.value,
      vehicleCategory: this.addForm.get("vehicleCategory")?.value
    }
      this.adminService.addVehicle(addVehicle).subscribe({
        next: (data) => {
          console.log(data);
          alert("Added Successfully");
          window.location.reload()
        },
        error: (error) => {
          alert("Error");
        }
      });
    }
    

onUpdate() {
  let updateVehicle: Vehicle = {
    vehicleId: this.updateForm.get("vehicleId")?.value,
    vehicleName: this.updateForm.get("vehicleName")?.value,
    vehicleCategory: this.updateForm.get("vehicleCategory")?.value
  }
  this.adminService.updateVehicle(updateVehicle).subscribe({
    next: (data) => {
      alert("updated Successfully");

      window.location.reload()
    },
    error: (error) => {
      alert("Error");
    }
  });
}

onDelete() {
  this.adminService.deleteVehicle(this.deleteForm.get("vehicleId")?.value).subscribe({
    next: (data) => {
      alert("delete Successfully");
      window.location.reload()
    },
    error: (error) => {
      alert("Error");
    }
  });
}



}
