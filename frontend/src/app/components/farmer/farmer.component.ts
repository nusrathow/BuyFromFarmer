import { Component } from '@angular/core';
import {ProductService} from "../product/productList/product.service";
import {Router} from "@angular/router";
import {FarmerService} from "./farmer.service";
import {Farmer} from "./farmer";

@Component({
  selector: 'app-farmer',
  templateUrl: './farmer.component.html',
  styleUrls: ['./farmer.component.css']
})
export class FarmerComponent {
  constructor(private productService:ProductService,private farmerService:FarmerService,
              private route:Router) {
  }

  farmerList!: any[];

  ngOnInit(): void {
    this.getAllFarmer();
  }
  private getAllFarmer(){
    this.farmerService.getAllFarmer().subscribe(data => {
      this.farmerList = data;
    });
  }

  // @ts-ignore
  goToFarmerDetails(farmerId){
    // @ts-ignore
    let passFarmerId :Farmer={
      id:farmerId
    }
    localStorage.setItem("passFarmerId",JSON.stringify(passFarmerId))
    this.route.navigate(['/farmer/farmerDetails']);
  }



}
