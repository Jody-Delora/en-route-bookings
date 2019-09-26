import { Component, OnInit } from '@angular/core';
import { UserService } from './../../services/user.service';
import {Router} from '@angular/router';
import {FlashMessagesService} from 'angular2-flash-messages';
import * as decode from 'jwt-decode';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  email1:string;
  password:string;

  constructor(private userService:UserService,private router:Router,private flashMessage:FlashMessagesService,private spinnerService: Ng4LoadingSpinnerService) { }

  ngOnInit() {
    this.userService.LoggedIn(true);
    localStorage.clear();
  }
onLoginSubmit(){

  const user={
    email1:this.email1,
    password:this.password
  }
  this.userService.authenticateUser(user).subscribe((data)=>{

   if(data!=undefined){
    this.userService.LoggedIn(false);
      localStorage.setItem('encode_token', data);

      if(decode(data).role=="ROLE_ADMIN"){ 
        /*this.userService.getUser(tokenPayLoad.userId).subscribe((user)=>{
        this.userService.storeUserData(JSON.stringify(tokenPayLoad),data,JSON.stringify(user));*/
          this.spinnerService.show();
          
          this.router.navigate(['dashboard']);
          this.flashMessage.show('You are now logged in',{
            cssClass:'alert-success',
            timeout:3000});
      
        }else if(decode(data).role=="ROLE_USER"){
          /*this.userService.getUser(tokenPayLoad.userId).subscribe((user)=>{
          this.userService.storeUserData(JSON.stringify(tokenPayLoad),data,JSON.stringify(user));  
            //this.spinnerService.show();*/
            this.router.navigate(['profile']);
            this.flashMessage.show('You are now logged in',{
              cssClass:'alert-success',
              timeout:3000});
        
      }
   }else{
        this.flashMessage.show('Invalid email address or password',{
          cssClass:'alert-danger',
          timeout:3000});
          this.router.navigate(['login']);
       
        } 
      });
        
  }

}




