import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "./category";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private baseURL ="http://localhost:8035/api/category";
  constructor(private httpClient:HttpClient) { }

  createNewCategory(farmer: Category): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, farmer);
  }

  updateCategory(farmer: Category): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}`, farmer);
  }

  getCategoryById(id: number): Observable<any>{
    return this.httpClient.get<any>(`${this.baseURL}/${id}`);
  }

  getAllCategory(): Observable<Category[]>{
    return this.httpClient.get<Category[]>(`http://localhost:8035/api/category/allCategory`);
  }
}
