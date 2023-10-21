import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FarmerDetailsComponent} from "../farmer/farmer-details/farmer-details.component";
import {FarmerComponent} from "../farmer/farmer.component";
import {CategoryComponent} from "./category.component";
import {ProductComponent} from "./productList/product.component";
import {ProductDetailsComponent} from "./product-details/product-details.component";


const routes: Routes = [
  {
    path: 'productList',
    component: ProductComponent
  },
  {
    path: '',
    component: CategoryComponent
  },
  {
    path: 'productList/productDetails',
    component: ProductDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CategoryRoutingModule { }
