import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../module/user';
import { Vehicle } from '../module/vehicle';

@Injectable({
  providedIn: 'root'
})

export class UserServiceService {

  constructor(private httpClient: HttpClient) { }

  registerUser(registerData: User) {
    return this.httpClient.post<User>("http://localhost:9005/api/v2/registerUser", registerData);
  }

  saveVehicletoCart(vehicle:Vehicle){
    const requestHeader = new HttpHeaders().set('Authorization','Bearer '+window.sessionStorage.getItem('token'));    
    return this.httpClient.post("http://localhost:9005/api/v2/user/saveCart",vehicle,{'headers':requestHeader});
  }

  getAllVehicle() {
    const requestHeader = new HttpHeaders().set('Authorization','Bearer '+window.sessionStorage.getItem('token'));
    return this.httpClient.get<Vehicle[]>("http://localhost:9005/api/v2/user/getCartItems", {'headers':requestHeader});
  }

  deletevehiclefromCart(vehicleId: any) {
    const requestHeader = new HttpHeaders().set('Authorization','Bearer '+window.sessionStorage.getItem('token'));    
    return this.httpClient.delete("http://localhost:9005/api/v2/user/cart/"+vehicleId,{'headers':requestHeader});
  }

}
