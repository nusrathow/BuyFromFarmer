import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FarmerDetailsComponent} from "./farmer-details/farmer-details.component";
import {FarmerComponent} from "./farmer.component";

const routes: Routes = [
  {
    path: 'farmerDetails',
    component: FarmerDetailsComponent
  },
  {
    path: '',
    component: FarmerComponent
  }
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FarmerRoutingModule {
}
