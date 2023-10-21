import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Checkout} from "../../checkout/checkout";
import {Observable} from "rxjs";
import {Farmer} from "../../farmer/farmer";
import {Product} from "./product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseURL ="http://localhost:8035/api/product";
  constructor(private httpClient:HttpClient) { }

  createNewProduct(product: Product): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, product);
  }

  updateProduct(product: Product): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}`, product);
  }

  getProductById(productList: number): Observable<any>{
    return this.httpClient.get<any>(`${this.baseURL}/${productList}`);
  }

  getProductByProductName(name: string): Observable<any>{
    return this.httpClient.get<any>(`${this.baseURL}/${name}`);
  }

  getProductsByCategoryId(categoryId: number): Observable<any>{
    return this.httpClient.get<any>(`http://localhost:8035/api/productList/productListByCatId/${categoryId}`);
  }

  getProductListById(id: number): Observable<any>{
    return this.httpClient.get<any>(`http://localhost:8035/api/productList/${id}`);
  }

  getAllProduct(): Observable<any[]>{
    return this.httpClient.get<any[]>(`http://localhost:8035/api/productList`);
  }

  createNewProductList(product: { image: string; name: string; categoryId: string; measurement: string },image:any): Observable<Object>{
    return this.httpClient.post(`http://localhost:8035/api/productList`,product,image);
  }
}
