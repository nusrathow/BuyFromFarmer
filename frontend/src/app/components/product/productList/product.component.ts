import { Component } from '@angular/core';
import {ProductService} from "./product.service";
import {FarmerService} from "../../farmer/farmer.service";
import {Router} from "@angular/router";
import {CategoryService} from "../category.service";
import {Farmer} from "../../farmer/farmer";
import {Product} from "./product";
import {Category} from "../category";

@Component({
  selector: 'app-productList',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  constructor(private productService:ProductService,private categoryService:CategoryService,
              private route:Router) {
  }
       // @ts-ignore
  temporaryId: Product = new Product();
  realId!:number;
  productList!:any;
  categoryName!:any;

  ngOnInit(): void {
     // @ts-ignore
    this.temporaryId = JSON.parse(localStorage.getItem("passCategoryId"))
    this.realId=Number(this.temporaryId.id);
    this.productService.getProductsByCategoryId(this.realId).subscribe(data => {
      this.productList = data;
    });
    this.categoryService.getCategoryById(this.realId).subscribe(data => {
      this.categoryName = data;
    });
  }

     // @ts-ignore
  goToProductDetails(productId){
    // @ts-ignore
    let passProductListId :Category={
      id:productId
    }
    localStorage.setItem("passProductListId",JSON.stringify(passProductListId))
    this.route.navigate(['/product/productList/productDetails']);
  }
}
