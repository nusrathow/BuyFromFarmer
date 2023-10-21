import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Farmer} from "./farmer";
import {Category} from "../product/category";

@Injectable({
  providedIn: 'root'
})
export class FarmerService {

  private baseURL ="http://localhost:8035/api/farmer";
  constructor(private httpClient:HttpClient) { }

  createNewFarmer(farmer: Farmer): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, farmer);
  }

  updateFarmer(farmer: Farmer): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}`, farmer);
  }

  getFarmerById(id: number): Observable<any>{
    return this.httpClient.get<any>(`${this.baseURL}/${id}`);
  }

  getAllFarmer(): Observable<any[]>{
    return this.httpClient.get<any[]>(`http://localhost:8035/api/farmer/allFarmer`);
  }
}
