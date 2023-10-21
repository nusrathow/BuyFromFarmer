import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Farmer} from "../farmer/farmer";
import {Observable} from "rxjs";
import {Checkout} from "./checkout";

@Injectable({
  providedIn: 'root'
})
export class CheckoutService {

  private baseURL ="http://localhost:8034/api/checkOut";
  constructor(private httpClient:HttpClient) { }

  searchCheckout(checkOut: Checkout): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, checkOut);
  }

  updateCheckout(checkOut: Checkout): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}`, checkOut);
  }

  getCheckoutById(id: number): Observable<any>{
    return this.httpClient.get<any>(`${this.baseURL}/${id}`);
  }
}
