import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { FirstComponent } from './first/first.component';
import { AdminComponent } from './admin/admin.component';
import { CartComponent } from './cart/cart.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { AuthGuard } from './auth.guard';
import { AdmincComponent } from './adminc/adminc.component';


const routes: Routes =
  [
    {
      path: 'vehicle', component: VehicleComponent,
    },
    {
      path: '', redirectTo: 'vehicle', pathMatch: 'full'
    },
    {
      path: 'first', component: FirstComponent
    },
    {
      path: 'admin', component: AdminComponent
    },
    {
      path: 'login', component: LoginComponent,
    },
    {
      path: "register", component: RegisterComponent
    },
    {
      path: "cart", component: CartComponent, canActivate: [AuthGuard]
    },
    {
      path: "adminc", component: AdmincComponent
    },
    {
      path: "updateVehicle/:vehicleId", component: AdminComponent
    }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
