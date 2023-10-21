import {Component, OnInit} from '@angular/core';
import {FarmerService} from "../farmer/farmer.service";
import {Farmer} from "../farmer/farmer";
import {Router} from "@angular/router";
import {AuthService} from "../../auth.service";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
/*export class SignupComponent {
  constructor(private farmerService:FarmerService,
              private route:Router) {
  }
/!*
  farmer=new Farmer();
  farmerId!:number;
  public user={
    username:'',
    password:'',
    firstname:'',
    lastname:'',
    email:'',
    phone:''
  }


  formSubmit(){
    this.farmer.name=this.user.username;
    this.farmer.phone=this.user.phone;
    this.farmer.password=this.user.password;
    this.farmerService.createNewFarmer(this.farmer).subscribe((response: any) =>{
     this.farmerId=response.id;
    })
    // @ts-ignore
    let sendFarmertoProduct :Farmer={
      id:this.farmerId
    }
    localStorage.setItem("sendFarmertoProduct",JSON.stringify(sendFarmertoProduct))
    this.route.navigate(['productAdd']);
  }*!/



}*/
export class SignupComponent implements OnInit {

  constructor(private authService: AuthService) { }

  username: string = '';
  password: string = '';

  user_roles: any = [
    {name:'User', value:'ROLE_USER', selected: false},
    {name:'Admin', value:'ROLE_ADMIN', selected: false},
    {name:'Anonymous', value:'ROLE_ANONYMOUS', selected: false},
  ]

  selectedRoles: any[] = [];

  error: string = '';
  success: string = '';

  ngOnInit(): void {
  }

  onChangeCategory(event: any, role: any) {
    this.selectedRoles.push(role.value);
  }

  doSignup() {
    if(this.username !== '' && this.username !== null && this.password !== '' && this.password !== null && this.selectedRoles.length > 0) {
      const request: { roles: string[]; userPwd: string; userName: string } = { userName: this.username, userPwd: this.password, roles: this.selectedRoles};

      console.log('re....',typeof(this.selectedRoles));
      this.authService.signup(request).subscribe((result)=> {
        //console.log(result);
        //this.success = 'Signup successful';
        this.success = result;
      }, (err) => {
        //console.log(err);
        this.error = 'Something went wrong during signup';
      });
    } else {
      this.error = 'All fields are mandatory';
    }
  }

}
