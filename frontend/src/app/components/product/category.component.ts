import { Component } from '@angular/core';
import {CategoryService} from "./category.service";
import {FarmerService} from "../farmer/farmer.service";
import {Router} from "@angular/router";
import {Farmer} from "../farmer/farmer";
import {Category} from "./category";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent {
  constructor(private categoryService:CategoryService,private farmerService:FarmerService,
              private route:Router) {
  }

  categoryList!: any[];

  ngOnInit(): void {
    this.getAllCategory();
  }
  private getAllCategory(){
    this.categoryService.getAllCategory().subscribe(data => {
      this.categoryList = data;
      console.log('......>>>>',this.categoryList);
    });
  }

  // @ts-ignore
  goToProductList(categoryId){
    // @ts-ignore
    let passCategoryId :Category={
      id:categoryId
    }
    localStorage.setItem("passCategoryId",JSON.stringify(passCategoryId))
    this.route.navigate(['/product/productList']);
  }
}
