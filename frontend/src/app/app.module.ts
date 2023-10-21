import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ModalModule } from 'ngx-bootstrap/modal';
import { SignupComponent } from './components/signup/signup.component';
import { LoginComponent } from './components/login/login.component';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { UserComponent } from './components/user/user.component';
import { FarmerComponent } from './components/farmer/farmer.component';
import { OrderComponent } from './components/order/order.component';
import { ProductComponent } from './components/product/productList/product.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import {HomeComponent} from "./components/home/home.component";
import { CategoryComponent } from './components/product/category.component';
import {FarmerDetailsComponent} from "./components/farmer/farmer-details/farmer-details.component";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from "@angular/material/card";
import { MatHint} from "@angular/material/form-field";
import {MatIconModule} from "@angular/material/icon";
import { ProductAddComponent } from './adminComponents/product-add/product-add.component';
import { FarmerAddComponent } from './adminComponents/farmer-add/farmer-add.component';
import {CommonModule} from "@angular/common";
import {MatSelectModule} from "@angular/material/select";
import {MatAutocompleteModule} from "@angular/material/autocomplete";

//import {Ng2SearchPipeModule} from "ng2-search-filter";


@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    UserComponent,
    FarmerComponent,
    OrderComponent,
    ProductComponent,
    CheckoutComponent,
    CategoryComponent,
    FarmerDetailsComponent,
    ProductAddComponent,
    FarmerAddComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        FontAwesomeModule,
        MatInputModule,
        MatFormFieldModule,
        ModalModule.forRoot(),
        BrowserAnimationsModule,
        ReactiveFormsModule,
        MatCardModule,
        MatIconModule,
        CommonModule,
        MatSelectModule,
        MatAutocompleteModule
    ],
  exports: [CommonModule, FormsModule, ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
  //@ts-ignore
  MatHint
}

