import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {UserService} from '../../services/user.service';
import {FlashMessagesService} from 'angular2-flash-messages';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  [x: string]: any;
  email1:string;
  password:string;
  firstName:string;
  lastName:string;
  mobile1:string;
  mobile2:string;
  dateOfBirth:Date;
  email2:string;
  gender:string;
  
  constructor(private _userService:UserService,private flashMessage:FlashMessagesService,private _router:Router,private route:ActivatedRoute) { }
  ngOnInit() {
    localStorage.clear();
  }
  onRegisterSubmit(){
    const user={
      email1:this.email1,
      password:this.password,
      firstName:this.firstName,
      lastName:this.lastName,
      mobile1:this.mobile1,
      mobile2:this.mobile2,
      dateOfBirth:this.dateOfBirth,
      email2:this.email2,
      gender:this.gender
    }
   
    
    /*if(!this.validateService.validateRegister(user)){
      this.flashMessage.show('Please fill in required fields',{cssClass:'alert-danger',timeout:3000});
      return false;
    }
    //validate email
    if(!this.validateService.validateEmail(user.email1)){
      this.flashMessage.show('Please use a valid email',{cssClass:'alert-danger',timeout:3000});
      return false;  
    }*/
    //Register user
    this._userService.addUser(user).subscribe(data=>{
        this.flashMessage.show('You are now registered and can log in',{cssClass:'alert-success',timeout:3000});
        this._router.navigate(['/login']);
  
    })
  }
}
  


 
  
  
  


