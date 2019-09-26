import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TransactionService } from './../../services/transaction.service';
import * as decode from 'jwt-decode';

@Component({
  selector: 'app-hotel-travellers',
  templateUrl: './hotel-travellers.component.html',
  styleUrls: ['./hotel-travellers.component.css']
})
export class HotelTravellersComponent implements OnInit {
  hotelInfo:any;
  room:any;
  hotelReservation:any;
  transaction:any;
  traveller:any;
  rooms:any;
  token:any;
  constructor(private _router: Router,private transactionService:TransactionService) { }

  ngOnInit() {
    const hotelInfo = JSON.parse(localStorage.getItem('hotelInfo'));
    this.hotelInfo = hotelInfo;

    const room = JSON.parse(localStorage.getItem('roomLog'));
    this.room = room;

    const hotelReservation = JSON.parse(localStorage.getItem('hotelReservation'));
    this.hotelReservation = hotelReservation;

    const token=localStorage.getItem('encode_token');
    this.token=token; 
  }

  back(){
    localStorage.removeItem('roomLog');
    this._router.navigate(['hotel-review']);
  }
  
  reserveHotel(contactName,personIsTravelling,email,cellPhone,homePhone,workPhone,address1,address2,cityOrTown,postalCode,province,country,saIdNo){
   
    for(let room of this.room){
      if(this.token==null){
        this.transaction={
          "transactionDate":Date.now(),
          "email":"",
          "hotelLog":{
            "hotelAddress1":this.hotelInfo.hotelAddress1,
            "hotelSuburb":this.hotelInfo.hotelSuburb,
            "hotelAddress2":this.hotelInfo.hotelSuburb,
            "hotelCity":this.hotelInfo.hotelCity,
            "hotelProvince":this.hotelInfo.hotelProvince,
            "hotelCountry":this.hotelInfo.hotelCountry,
            "hotelName":this.hotelInfo.hotelName,
            "hotelDescription":this.hotelInfo.hotelDescription,
            "hotelImage":this.hotelInfo.hotelImage,
            "propertyAmenities":this.hotelInfo.propertyAmenities,
            "propertyType":this.hotelInfo.propertyType,
            "locationType":this.hotelInfo.locationType,
            "hotelChain":this.hotelInfo.hotelChain,
            "starRating":this.hotelInfo.starRating,
            "checkInDate":this.hotelReservation.checkInDate,
            "checkOutDate":this.hotelReservation.checkOutDate,
            "roomLog":[{
              "roomType":room.roomType,
              "roomDescription":room.roomDescription,
              "roomAmenity":room.roomAmenity,
              "roomPrice":room.roomPrice,
              "traveller":room.traveller,
              "primaryContact":{
                "contactName":contactName,
                "personIsTravelling":personIsTravelling,
                "email":email,
                "cellPhone":cellPhone,
                "homePhone":homePhone,
                "workPhone":workPhone,
                "address1":address1,
                "address2":address2,
                "cityOrTown":cityOrTown,
                "postalCode":postalCode,
                "province":province,
                "country":country,
                "saIdNo":saIdNo
                }
            }]
          }
    }
  }else{
      this.transaction={
        "transactionDate":Date.now(),
        "userId":decode(this.token).userId,
        "email":decode(this.token).sub,
        "hotelLog":{
          "hotelAddress1":this.hotelInfo.hotelAddress1,
          "hotelSuburb":this.hotelInfo.hotelSuburb,
          "hotelAddress2":this.hotelInfo.hotelSuburb,
          "hotelCity":this.hotelInfo.hotelCity,
          "hotelProvince":this.hotelInfo.hotelProvince,
          "hotelCountry":this.hotelInfo.hotelCountry,
          "hotelName":this.hotelInfo.hotelName,
          "hotelDescription":this.hotelInfo.hotelDescription,
          "hotelImage":this.hotelInfo.hotelImage,
          "propertyAmenities":this.hotelInfo.propertyAmenities,
          "propertyType":this.hotelInfo.propertyType,
          "locationType":this.hotelInfo.locationType,
          "hotelChain":this.hotelInfo.hotelChain,
          "starRating":this.hotelInfo.starRating,
          "checkInDate":this.hotelReservation.checkInDate,
          "checkOutDate":this.hotelReservation.checkOutDate,
          "roomLog":[{
            "roomType":room.roomType,
            "roomDescription":room.roomDescription,
            "roomAmenity":room.roomAmenity,
            "roomPrice":room.roomPrice,
            "traveller":room.traveller,
            "primaryContact":{
              "contactName":contactName,
              "personIsTravelling":personIsTravelling,
              "email":email,
              "cellPhone":cellPhone,
              "homePhone":homePhone,
              "workPhone":workPhone,
              "address1":address1,
              "address2":address2,
              "cityOrTown":cityOrTown,
              "postalCode":postalCode,
              "province":province,
              "country":country,
              "saIdNo":saIdNo
              }
          }]
        }
  } 

    }
console.log(this.transaction);
    this.transactionService.makeTransaction(this.transaction).subscribe((transactions)=>{

    });
    this._router.navigate(['hotel-confirmation']);
  }
  }
}
