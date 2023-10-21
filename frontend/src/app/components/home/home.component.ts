import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ProductService} from "../product/productList/product.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private productService:ProductService,
              private route:Router) {
  }
  productSearchResult!: any[];
  ngOnInit(): void {
  }

  productSearch(value: string){
    console.log('value---',value)
    this.productService.getProductByProductName(value).subscribe( data =>{
        this.productSearchResult=data as any[];
        console.log('this.productSearchResult---',this.productSearchResult)
      },
      error => console.log(error));
  }

  goToFarmer(){
    this.route.navigate(['farmerDetails']);
}

}

