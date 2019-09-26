import { Component, OnInit } from '@angular/core';
import { HotelService } from './../../services/hotel.service';
import {AircraftService} from '../../services/aircraft.service';
import {FlashMessagesService} from 'angular2-flash-messages';
import {CarService} from '../../services/car.service';
import {Router} from '@angular/router';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { UserService } from './../../services/user.service';
import { Time } from '@angular/common';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  today = new Date().toJSON().split('T')[0];
  branchName:string;
  departureLocation:string;
  arrivalLocation:string;
  departureDate:Date;
  className:string;
  travellerQuantity;
  traveller=1;
  roomTotal=1;
  travellers:any;
  room=[]
  travellerList=[];
  constructor(private _aircraftService:AircraftService,private _carService:CarService,private _hotelService:HotelService,private _router:Router,private flashMessage:FlashMessagesService, private spinnerService: Ng4LoadingSpinnerService,private userService:UserService) { }

  ngOnInit() {
  this.userService.LoggedIn(true);
  localStorage.clear();
  this.spinnerService.hide();
  this.travellerQuantity=1
  this.room=new Array(this.roomTotal);
  this.travellerList=new Array(this.travellerQuantity)
 
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
  console.log(this.room.length);
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
    console.log(hotelReservation);
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
  //this.spinnerService.show();
  this._router.navigate(['/flight-selection']);

    }
  },(error)=>{
    console.log(error)
  })
  
  }
}

