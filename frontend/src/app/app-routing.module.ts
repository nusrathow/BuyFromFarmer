import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SignupComponent} from "./components/signup/signup.component";
import {LoginComponent} from "./components/login/login.component";
import {HomeComponent} from "./components/home/home.component";
import {ProductComponent} from "./components/product/productList/product.component";
import {FarmerComponent} from "./components/farmer/farmer.component";
import {CategoryComponent} from "./components/product/category.component";
import {OrderComponent} from "./components/order/order.component";
import {FarmerDetailsComponent} from "./components/farmer/farmer-details/farmer-details.component";
import {ProductAddComponent} from "./adminComponents/product-add/product-add.component";
import {FarmerAddComponent} from "./adminComponents/farmer-add/farmer-add.component";



const routes: Routes = [
  {path: 'login', component: LoginComponent,},
  {path: 'signup', component: SignupComponent,},
  {path: 'home', component: HomeComponent,},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'productList', component: ProductComponent,},
  {
    path: 'product',
    loadChildren: () => import('./components/product/category.module').then(m => m.CategoryModule)
  },
  {path: 'farmerDetails', component: FarmerDetailsComponent},
  {path: 'order', component: OrderComponent,},
  {
    path: 'farmer',
    loadChildren: () => import('./components/farmer/farmer.module').then(m => m.FarmerModule)
  },
  {path: 'productAdd', component: ProductAddComponent,},
  {path: 'farmerAdd', component: FarmerAddComponent,},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
