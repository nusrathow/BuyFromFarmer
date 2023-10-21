import { Component } from '@angular/core';
import {Farmer} from "../../components/farmer/farmer";
import {ProductService} from "../../components/product/productList/product.service";
import {Product} from "../../components/product/productList/product";

@Component({
  selector: 'app-productList-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent {
  constructor(private productService:ProductService) {
  }

  public user={
    name:'',
    image:'',
    categoryId:'',
    measurement:''
  }

  file!:any;
  name!:any;

getFile(event:any){
    this.file=event.target.files[0];
}

  getName(name:string){
    this.name=name;
  }


  onSubmit() {
    let formData = new FormData();
    formData.set("name",this.name);
    formData.set("file",this.file);

      this.productService.createNewProductList(this.user,formData).subscribe((response: any) => {
        console.log('done...',response)
      })

    }
}
