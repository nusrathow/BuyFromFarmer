import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user={
    username:'',
    password:'',
    firstname:'',
    lastname:'',
    email:'',
    phone:''
  }






  username: string = '';
  password : string = '';

  isSignedin = false;

  error: string = '';

  constructor(private route: ActivatedRoute, private router: Router, private authService: AuthService) {}

  ngOnInit() {
    this.isSignedin = this.authService.isUserSignedin();

    if(this.isSignedin) {
      this.router.navigateByUrl('home');
    }
  }

  doSignin() {
    if(this.username !== '' && this.username !== null && this.password !== '' && this.password !== null) {
      const request: { userPwd: string; userName: string } = { userName: this.username, userPwd: this.password};

      this.authService.signin(request).subscribe((result)=> {
        //this.router.navigate(['/home']);
        this.router.navigateByUrl('home');
      }, () => {
        this.error = 'Either invalid credentials or something went wrong';
      });
    } else {
      this.error = 'Invalid Credentials';
    }
  }
}
