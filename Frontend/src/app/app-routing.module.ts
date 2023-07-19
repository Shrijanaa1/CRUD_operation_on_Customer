import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { DeleteCustomerComponent } from './delete-customer/delete-customer.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path: 'customers', component: CustomerListComponent},
  {path: 'create-customer', component: CreateCustomerComponent},
    // if empty path, it redirects to path customers.
  //pathMatch: 'full' ensures that entire URL must match the specified path for the redirection to occur.
  
  {path: '', redirectTo: 'customers', pathMatch: 'full' },  
  {path: 'update-customer/:id', component: UpdateCustomerComponent},
  {path: 'delete-customer/:id', component: DeleteCustomerComponent},
  {path: 'view-customer/:id', component: ViewCustomerComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
