import { Component } from '@angular/core';
import {FarmerService} from "../../components/farmer/farmer.service";
import {Router} from "@angular/router";
import {Farmer} from "../../components/farmer/farmer";
import {Product} from "../../components/product/productList/product";
import {FormBuilder, FormArray, FormGroup, FormControl, Validators} from "@angular/forms";
import {CategoryService} from "../../components/product/category.service";
import {ProductService} from "../../components/product/productList/product.service";


@Component({
  selector: 'app-farmer-add',
  templateUrl: './farmer-add.component.html',
  styleUrls: ['./farmer-add.component.css']
})
export class FarmerAddComponent {

  hide = true;
  categories!: any[];
  productList!: any[];
  measurements!: string;
  skillsForm: FormGroup;

  ngOnInit(): void {
   this.getJourneyFrom();
  }
  private getJourneyFrom(){
    this.categoryService.getAllCategory().subscribe(data => {
      this.categories = data;
    });
  }

  public getCatId(h: any) {
    this.productService.getProductsByCategoryId(h).subscribe(data => {
      this.productList = data;
    });
  }

  public getProdId(h: any) {
    this.productService.getProductListById(h).subscribe(data => {
      this.measurements = data.measurement;
    });
  }

  constructor(private farmerService: FarmerService,private categoryService: CategoryService,private productService: ProductService,
              private route: Router,private fb: FormBuilder) {
    this.skillsForm = this.fb.group({
      name: '',
      password: '',
      phone: '',
      products: this.fb.array([this.newSkill()]) ,
    });
  }


  get products() : FormArray {
    return this.skillsForm.get("products") as FormArray
  }

  newSkill(): FormGroup {
    return this.fb.group({
      category: '',
      productList: '',
      price: '',
      quantity: ''
    })
  }

  addSkills() {
    this.products.push(this.newSkill());
  }

  removeSkill(i:number) {
    this.products.removeAt(i);
  }


  onSubmit() {
    this.farmerService.createNewFarmer(this.skillsForm.value).subscribe((response: any) => {
      /////////update product with farmerID from this response
      this.productService.updateProduct(response.data.id).subscribe((response: any) => {
      })
      console.log('done...')
    })
  }
}
