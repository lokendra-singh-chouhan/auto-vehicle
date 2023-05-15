import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vehicle } from '../module/vehicle';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient: HttpClient) { }
  
  getAllVehicles() {
    return this.httpClient.get("http://localhost:9005/api/v3/getAllVehicles");
  }

  addVehicle(vehicle: Vehicle) {
    return this.httpClient.post("http://localhost:9005/api/v3/addVehicle", vehicle);
  }

  updateVehicle(vehicle: Vehicle) {
    return this.httpClient.put("http://localhost:9005/api/v3/updateVehicle", vehicle);
  }

  deleteVehicle(vehicleId: String) {
    return this.httpClient.delete("http://localhost:9005/api/v3/deleteVehicle/"+vehicleId);
  }

}
