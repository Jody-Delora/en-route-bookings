import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FlashMessagesService} from 'angular2-flash-messages';
import { UserService } from './../../services/user.service';
import {AircraftService} from '../../services/aircraft.service';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { HotelService } from './../../services/hotel.service';
import {CarService} from '../../services/car.service';
import * as decode from 'jwt-decode';
import { TransactionService } from '../../services/transaction.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user:any;
  token:any;
  firstName:string;
  lastName:string;
  dateOfBirth:Date;
  gender:string;
  mobile1:string;
  mobile2:string;
  email1:string;
  email2:string;
  password:string;
  id:number;
  permission:any;
  departureLocation:string;
  arrivalLocation:string;
  departureDate:Date;
  className:string;
  transaction:any;

  cardNumber:String;
  cardName:String;
  expirationDate:Date;
  cvc:String;

  billingAddress1:String;
  billingSuburb:String;
  billingCountry:String;
  billingCity:String;
  billingPostalCode:String;

  today = new Date().toJSON().split('T')[0];
  branchName:string;
  traveller=1;
  travellers:any;
  travellerQuantity;
  roomTotal=1;
  room=[]
  travellerList=[];

  constructor(private userService:UserService,private _aircraftService:AircraftService,private _carService:CarService,private _hotelService:HotelService,private _router:Router,private flashMessage:FlashMessagesService,private spinnerService: Ng4LoadingSpinnerService,private transactionService:TransactionService) { }

  ngOnInit() {
  
    this.spinnerService.hide();
    const token=localStorage.getItem('encode_token');
    this.token=token;

    this.userService.getUser(decode(token).userId,token).subscribe((user)=>{
      this.spinnerService.hide();  
      this.user=user;
      this.id=this.user.id;
      this.password=this.user.password;
      this.permission=this.user.permission;
      this.firstName=this.user.firstName;
      this.lastName=this.user.lastName;
      this.dateOfBirth=this.user.dateOfBirth;
      this.gender=this.user.gender;
      this.mobile1=this.user.mobile1;
      this.mobile2=this.user.mobile2;
      this.email1=this.user.email1;
      this.email2=this.user.email2;
      if(this.user.cardDetails!=null){

      }
      if(this.user.billingDetails!=null){
        this.billingAddress1=this.user.billingDetails.billingAddress1
        this.billingSuburb=this.user.billingDetails.billingSuburb
        this.billingCountry=this.user.billingDetails.billingCountry
        this.billingCity=this.user.billingDetails.billingCity
        this.billingPostalCode=this.user.billingDetails.billingPostalCode

      }
   // this.userService.storeUserData(JSON.stringify(token),JSON.stringify(user))
  });  
  this.transactionService.getUserTransactions(decode(token).userId).subscribe((transaction)=>{
    this.transaction=transaction;
    console.log(this.transaction);
  });
  }

  billingInfo(billingAddress1,billingSuburb,billingCountry,billingCity,billingPostalCode){
    const user={
      id:this.id,
      permission:this.permission,
      password:this.password,
      email1:this.email1,
      firstName:this.firstName,
      lastName:this.lastName,
      mobile1:this.mobile1,
      mobile2:this.mobile2,
      dateOfBirth:this.dateOfBirth,
      email2:this.email2,
      gender:this.gender,
      "billingDetails":{
        billingAddress1:this.billingAddress1,
        billingSuburb:this.billingSuburb,
        billingCountry:this.billingCountry,
        billingCity:this.billingCity,
        billingPostalCode:this.billingPostalCode
      }
      
    }
    this.userService.updateUser(user).subscribe(user=>{
      this._router.navigate(['profile']);
      this.flashMessage.show('Your details have been updated ',{
        cssClass:'alert-success',timeout:3000}
        );
  
    })
  }

  onChange(){
    const roomInfo={
      "roomType":"",
      "roomDescription":"",
      "roomAmenity":"",
      "roomPrice":"",
      "travellerQuantity":""
    }
    this.room=new Array(this.roomTotal);
    for(let i=0;i<=this.roomTotal-1;i++){
      this.room[i]=roomInfo;
    }
    
  }
  onTraveller(event,i){
    const travellerInfo={
      "title":"",
      "firstName":"",
      "lastName":"",
    }
this.travellerList=new Array(this.travellerQuantity)

for(let j=0;j<=this.travellerQuantity-1;j++){
this.travellerList[j]=travellerInfo
}
  this.room[i]={
    "roomType":"",
    "roomDescription":"",
    "roomAmenity":"",
    "roomPrice":"",
    "traveller":this.travellerList
}

  }
  onCarSearch(pickUpLocation,pickUpDate,pickUpTime,dropOffLocation,dropOffDate,dropOffTime){
    const carHireInfo={
      "pickUpLocation":pickUpLocation,
      "pickUpDate":pickUpDate,
      "pickUpTime":pickUpTime.concat(':00'),
      "dropOffLocation":dropOffLocation,
      "dropOffDate":dropOffDate,
      "dropOffTime":dropOffTime.concat(':00')
    }
    this._carService.getAllCars(pickUpLocation).subscribe((car:any)=>{  
      if(car.length==0){
        this.flashMessage.show('No cars Available, Please try Another Date',{
          cssClass:'alert-danger',
          timeout:5000});
      }else{
        localStorage.setItem('car', JSON.stringify(car));
        localStorage.setItem('carHireInfo', JSON.stringify(carHireInfo));
        this._router.navigate(['car-selection']);
      }
    },(error)=>{
      console.log(error)
    })
     
  }
  onHotelSearch(hotelCity,hotelProvince,locationType,propertyType,checkInDate,checkOutDate,hotelName,hotelChain,starRating){
    const hotelReservation={
      "checkInDate":checkInDate,
      "checkOutDate":checkOutDate
    }
    this._hotelService.getSearch(hotelCity,hotelProvince,locationType,propertyType,hotelName,hotelChain,starRating).subscribe((hotel:any)=>{
      if(hotel.length==0){
        this.flashMessage.show('No hotels found, Please try Another Location',{
          cssClass:'alert-danger',
          timeout:5000});
      }else{
        localStorage.setItem('hotel', JSON.stringify(hotel));
        localStorage.setItem('room',JSON.stringify(this.room));
        localStorage.setItem('hotelReservation', JSON.stringify(hotelReservation));
        this._router.navigate(['hotel-selection']);
      }
    })
  }
  onSearch(){

    this._aircraftService.getSearch(this.departureLocation,this.arrivalLocation,this.departureDate,this.className).subscribe((data:any)=>{  
      if(data.length==0){
        this.flashMessage.show('No Flights Available, Please try Another Date',{
          cssClass:'alert-danger',
          timeout:5000});
      }else{
    this._aircraftService.storeFlightData(data,this.traveller);
    this.spinnerService.show();
    this._router.navigate(['/flight-selection']);
  
      }
    },(error)=>{
      console.log(error)
    })
    
    }

  /*onSignOut(){
    
    this.flashMessage.show('You are now logged out',{
      cssClass:'alert-success',
      timeout:3000
    });
    this._router.navigate(['/login']);
    return false;
  }*/
updateUser(){
  const user={
    id:this.id,
    permission:this.permission,
    password:this.password,
    email1:this.email1,
    firstName:this.firstName,
    lastName:this.lastName,
    mobile1:this.mobile1,
    mobile2:this.mobile2,
    dateOfBirth:this.dateOfBirth,
    email2:this.email2,
    gender:this.gender
  }
  this.userService.updateUser(user).subscribe(user=>{
    this._router.navigate(['profile']);
    this.flashMessage.show('Your details have been updated ',{
      cssClass:'alert-success',timeout:3000}
      );

  })
}
updatePassword(oldPassword,newPassword){

  if(oldPassword==this.password){
    const user={
      id:this.id,
      permission:this.permission,
      password:newPassword,
      email1:this.user.email1,
      firstName:this.user.firstName,
      lastName:this.user.lastName,
      mobile1:this.user.mobile1,
      mobile2:this.user.mobile2,
      dateOfBirth:this.user.dateOfBirth,
      email2:this.user.email2,
      gender:this.user.gender
    }
    this.userService.updateUser(user).subscribe(user=>{
      this._router.navigate(['profile']);
      /*localStorage.setItem('user',user);*/
      this.flashMessage.show('Your password have been updated',{
        cssClass:'alert-success',timeout:3000}
        );
  
    })
  }else{
    this.flashMessage.show('Your old Password is incorrect',{
      cssClass:'alert-danger',timeout:3000}
      );
  }
  
}

}
