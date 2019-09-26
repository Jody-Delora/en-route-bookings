import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FlashMessagesService} from 'angular2-flash-messages';
import { UserService } from './../../services/user.service';
import { Time } from '@angular/common';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import * as decode from 'jwt-decode';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  token:any;
  user:any;
  aircraftName:string;
  carierName:string;
  carierLogo:string;
  arrivalTime:Time;
  flight:any;
  arrivalLocation:string;
  arrivalDate:Date;
  departureDate:Date;
  departureTime:Time;
  departureLocation:string;
  flightNo:string;
  airlineClass:string;
  className:string;
  seat_plan:any;
  seat_row:number;
  seat_column:string;
  seat_position:string;
  seat_occupied:boolean;
  seat_type:string;
  seat_price:number;
  fare:any;
  fare_type:string;
  fare_description:string;
  fare_price:number;
  max_seats:number;
  flightExtra:any;
  extra_type:string;
  extra_description:string;
  extra_price:number;
  email:String;
  constructor(private userService:UserService,private router:Router,private flashMessage:FlashMessagesService,private spinnerService: Ng4LoadingSpinnerService) { }

  ngOnInit() {
    this.userService.LoggedIn(false);
    const token=localStorage.getItem('encode_token');
    this.email=decode(token).sub;
    this.userService.getUser(decode(token).userId,token).subscribe((user)=>{
      this.user=user;
   // this.userService.storeUserData(JSON.stringify(token),JSON.stringify(user))
  });
      
    this.spinnerService.hide();
  }
  addFlight(){
    this.router.navigate(['add-flight'])
  }
  addCar(){
    this.router.navigate(['add-car'])
  }
  addHotel(){
    this.router.navigate(['add-hotel'])
  }
  /*onSubmit(){
    const aircraft={
      aircraftName:this.aircraftName,
      carierName:this.carierName,
      carierLogo:this.carierLogo,
      flight:{
        arrivalTime:this.arrivalTime,
        arrivalLocation:this.arrivalLocation,
        arrivalDate:this.arrivalLocation,
        departureDate:this.departureDate,
        departureTime:this.departureTime,
        departureLocation:this.departureLocation,
        flightNo:this.flightNo,
        airlineClass:{
          className:this.className,
          seat_plan:[{
            seat_row:this.seat_row,
            seat_column:this.seat_column,
            seat_position:this.seat_position,
            seat_occupied:this.seat_occupied,
            seat_type:this.seat_type,
            seat_price:this.seat_price
          }],
          fare:[{
            fare_type:this.fare_type,
            fare_description:this.fare_description,
            fare_price:this.fare_price,
            max_seats:this.max_seats
          }]
        },
        flightExtra:[{
          extra_type:this.extra_type,
          extra_description:this.extra_description,
          extra_price:this.extra_price
        }]
      }
    }
  }
onSignOut(){
  this.userService.signOut();
  this.flashMessage.show('You are now logged out',{
    cssClass:'alert-success',
    timeout:3000
  });
  this.router.navigate(['/login']);
  return false;
}*/
}

