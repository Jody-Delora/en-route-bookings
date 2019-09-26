import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-hotel-selection',
  templateUrl: './hotel-selection.component.html',
  styleUrls: ['./hotel-selection.component.css']
})
export class HotelSelectionComponent implements OnInit {
  hotel:any;
  hotelReservation:any;
    constructor(private _router:Router) { }
  
    ngOnInit() {
      const hotel=JSON.parse(localStorage.getItem('hotel'));
      this.hotel=hotel;
      const hotelReservation=JSON.parse(localStorage.getItem('hotelReservation')); 
      this.hotelReservation=hotelReservation; 
    }
  selectHotel(hotelAddress1,hotelSuburb,hotelCity,hotelProvince,hotelCountry,hotelName,hotelDescription,hotelImage,room,propertyAmenities,propertyType,locationType,hotelChain,starRating){
  const hotelInfo={
    "hotelAddress1":hotelAddress1,
    "hotelSuburb":hotelSuburb,
    "hotelCity":hotelCity,
    "hotelProvince":hotelProvince,
    "hotelCountry":hotelCountry,
    "hotelName":hotelName,
    "hotelDescription":hotelDescription,
    "hotelImage":hotelImage,
    "room":room,
    "propertyAmenities":propertyAmenities,
    "propertyType":propertyType,
    "locationType":locationType,
    "hotelChain":hotelChain,
    "starRating":starRating
  }
  localStorage.setItem('hotelInfo', JSON.stringify(hotelInfo));
  this._router.navigate(['hotel-review']);
  }
  }
  