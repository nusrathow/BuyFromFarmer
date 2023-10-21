import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Farmer} from "../farmer/farmer";
import {Observable} from "rxjs";
import {User} from "./user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseURL ="http://localhost:8034/api/user";
  constructor(private httpClient:HttpClient) { }

  searchUser(user: User): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, user);
  }

  updateUser(user: User): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}`, user);
  }

  getUserById(id: number): Observable<any>{
    return this.httpClient.get<any>(`${this.baseURL}/${id}`);
  }
}
