import { Component } from '@angular/core';
import {ProductService} from "../../product/productList/product.service";
import {Router} from "@angular/router";
import {Farmer} from "../farmer";
import {FarmerService} from "../farmer.service";

@Component({
  selector: 'app-farmerDetails',
  templateUrl: './farmer-details.component.html',
  styleUrls: ['./farmer-details.component.css']
})
export class FarmerDetailsComponent {
  constructor(private productService:ProductService,private farmerService:FarmerService,
              private route:Router) {
  }

  // @ts-ignore
  temporaryId: Farmer = new Farmer();
  realId!:number;
  farmerDetails!:any;

  addToCart(){
    this.route.navigate(['order']);
  }
  ngOnInit(): void {
    // @ts-ignore
    this.temporaryId = JSON.parse(localStorage.getItem("passFarmerId"))
    this.realId=Number(this.temporaryId.id);
    this.farmerService.getFarmerById(this.realId).subscribe(data => {
      this.farmerDetails = data;
      console.log('....f',this.farmerDetails)
    });
  }

}
