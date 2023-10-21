import { Component } from '@angular/core';
import {ProductService} from "../productList/product.service";
import {CategoryService} from "../category.service";
import {Router} from "@angular/router";
import {Product} from "../productList/product";
import {FarmerService} from "../../farmer/farmer.service";

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent {

  constructor(private productService:ProductService,private categoryService:CategoryService,private farmerService:FarmerService,
              private route:Router) {
  }
  // @ts-ignore
  temporaryId: Product = new Product();
  realId!:number;
  farmerList!:any[];
  productList!:any[];
  categoryName!:any;


  ngOnInit(): void {
    // @ts-ignore
    this.temporaryId = JSON.parse(localStorage.getItem("passProductListId"))
    this.realId = Number(this.temporaryId.id);
    this.productService.getProductById(this.realId).subscribe(data => {
      this.productList = data;
      console.log('productList.....', this.productList)
      for (let l in this.productList) {
        this.farmerService.getFarmerById(this.productList[l].farmerId).subscribe(data => {
          this.productList[l].farmerId = (data.name);
        })
      }
    });
  }
}
