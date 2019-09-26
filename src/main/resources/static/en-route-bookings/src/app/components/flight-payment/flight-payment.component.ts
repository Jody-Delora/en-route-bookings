import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AircraftService} from '../../services/aircraft.service';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { Timestamp } from 'rxjs';
import * as decode from 'jwt-decode';
import { TransactionService } from './../../services/transaction.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-flight-payment',
  templateUrl: './flight-payment.component.html',
  styleUrls: ['./flight-payment.component.css']
})
export class FlightPaymentComponent implements OnInit {

  data:any;
  seatInfo:any;
  flightInfo:any;
  traveller:any;
  travellerInfo:any;
  seatTotal=0;
  taxTotal=0;
  fareTotal=0;
  extraTotal=0;
  flightTotal=0;
  grandTotal=0;
  flightExtras:any;
  flightLog:any;
  token:any;
  user:any;
  email:any;
  transaction:any;
  billingAddress1:String;
  billingSuburb:String;
  billingCountry:String;
  billingCity:String;
  billingPostalCode:String;

  today = new Date().toJSON().split('T')[0];
  constructor(private _router:Router,private _aircraftService:AircraftService,private transactionService:TransactionService,private spinnerService: Ng4LoadingSpinnerService,private userService:UserService) { }

  ngOnInit() {
    this.spinnerService.hide();
    const flightInfo=JSON.parse(localStorage.getItem('flightInfo'));
    this.flightInfo=flightInfo; 

    const traveller=JSON.parse(localStorage.getItem('traveller'));
    this.traveller=traveller; 

    const token=localStorage.getItem('encode_token');
    this.token=token; 

    this.userService.getUser(decode(token).userId,token).subscribe((user)=>{
      this.user=user;
      this.email=this.user.email1;

      if(this.user.billingDetails!=null){
        this.billingAddress1=this.user.billingDetails.billingAddress1
        this.billingSuburb=this.user.billingDetails.billingSuburb
        this.billingCountry=this.user.billingDetails.billingCountry
        this.billingCity=this.user.billingDetails.billingCity
        this.billingPostalCode=this.user.billingDetails.billingPostalCode

      }
    });
    

    const data=JSON.parse(localStorage.getItem('data'));
    this.data=data; 

    const seatInfo=JSON.parse(localStorage.getItem('seatInfo'));
    this.seatInfo=seatInfo; 

    const travellerInfo=JSON.parse(localStorage.getItem('travellerList'));
    this.travellerInfo=travellerInfo; 

    const flightExtras=JSON.parse(localStorage.getItem('flightExtras'));
    this.flightExtras=flightExtras; 

    this.fareTotal=flightInfo.farePrice*traveller;
    this.flightTotal=flightInfo.farePrice*traveller;
    this.taxTotal=flightInfo.passengerSafetyCharge+flightInfo.passengerSecurityCharge+flightInfo.passengerServiceCharge+flightInfo.VAT;
    for(let i=0;i<seatInfo.length;i++){
      this.seatTotal+=seatInfo[i].seatPrice;
    } 
    for(let i=0;i<flightExtras.length;i++){
      this.extraTotal+=flightExtras[i].extraPrice;
    } 
    this.grandTotal=this.flightTotal+this.seatTotal+this.extraTotal
  }

back(){
  localStorage.removeItem('flightExtras');
  this.spinnerService.show();
  this._router.navigate(['flight-extra']);
}
bookFlight(cardNumber,cardName,expirationDate,cvv,email,billingAddress1,billingSuburb,billingCity,billingCountry,billingPostalCode){         
  if(this.token==null){
    this.transaction={
            "cardNumber":cardNumber,
            "cardName":cardName,
            "expirationDate":expirationDate,
            "paymentMethod":"Credit Card",
            "cvv":cvv,
            "email":email,
            "billingAddress1":billingAddress1,
            "billingSuburb":billingSuburb,
            "billingCity":billingCity,
            "billingCountry":billingCountry,
            "billingPostalCode":billingPostalCode,
            "transactionDate":Date.now(),
            "flightLog":{
              "departureDate":this.flightInfo.departureDate,
              "departureTime":this.flightInfo.departureTime,
              "departureLocation":this.flightInfo.departureLocation,
              "arrivalDate":this.flightInfo.arrivalDate,
              "arrivalTime":this.flightInfo.arrivalTime,
              "arrivalLocation":this.flightInfo.arrivalLocation,
              "flightNo":this.flightInfo.flightNo,
              "aircraftName":this.flightInfo.aircraftName,
              "carrierLogo":this.flightInfo.carrierLogo,
              "carrierName":this.flightInfo.carrierName,
              "className":this.flightInfo.className,
              "fareType":this.flightInfo.fareType,
              "passengerSafetyCharge":this.flightInfo.passengerSafetyCharge,
              "passengerSecurityCharge":this.flightInfo.passengerSecurityCharge,
              "passengerServiceCharge":this.flightInfo.passengerServiceCharge,
              "VAT":this.flightInfo.VAT,
              "flightTotal":this.flightTotal,
              "taxTotal":this.taxTotal,
              "seatTotal":this.seatTotal,
              "extraTotal":this.extraTotal,
              "grandTotal":this.grandTotal,
              "seatLog":this.seatInfo,
              "flightExtraLog":this.flightExtras,
              "traveller":this.travellerInfo
            }
    }
  }else{
     this.transaction={
      /*"transaction":{*/
        "cardNumber":cardNumber,
        "cardName":cardName,
        "expirationDate":expirationDate,
        "paymentMethod":"Credit Card",
        "cvv":cvv,
        "email":email,
        "billingAddress1":billingAddress1,
        "billingSuburb":billingSuburb,
        "billingCity":billingCity,
        "billingCountry":billingCountry,
        "billingPostalCode":billingPostalCode,
        "transactionDate":Date.now(),
        "userId":decode(this.token).userId,
        "flightLog":{
          "departureDate":this.flightInfo.departureDate,
          "departureTime":this.flightInfo.departureTime,
          "departureLocation":this.flightInfo.departureLocation,
          "arrivalDate":this.flightInfo.arrivalDate,
          "arrivalTime":this.flightInfo.arrivalTime,
          "arrivalLocation":this.flightInfo.arrivalLocation,
          "flightNo":this.flightInfo.flightNo,
          "aircraftName":this.flightInfo.aircraftName,
          "carrierLogo":this.flightInfo.carrierLogo,
          "carrierName":this.flightInfo.carrierName,
          "className":this.flightInfo.className,
          "fareType":this.flightInfo.fareType,
          "passengerSafetyCharge":this.flightInfo.passengerSafetyCharge,
          "passengerSecurityCharge":this.flightInfo.passengerSecurityCharge,
          "passengerServiceCharge":this.flightInfo.passengerServiceCharge,
          "VAT":this.flightInfo.VAT,
          "flightTotal":this.flightTotal,
          "taxTotal":this.taxTotal,
          "seatTotal":this.seatTotal,
          "extraTotal":this.extraTotal,
          "grandTotal":this.grandTotal,
          "seatLog":this.seatInfo,
          "flightExtraLog":this.flightExtras,
          "traveller":this.travellerInfo
      }
   /* }*/
  }

  }

for(let seat of this.seatInfo){
  const seatInfo={
    "id":seat.id,
    "seatRow":seat.seatRow,
    "seatColumn":seat.seatColumn,
    "seatType":seat.seatType,
    "seatPosition":seat.seatPosition,
    "seatPrice":seat.seatPrice,
    "seatOccupied":1
  }
  this.transactionService.updateSeat(seat.id,seatInfo).subscribe(seat=>{
  })
}
console.log(this.transaction)
  this.transactionService.makeTransaction(this.transaction).subscribe(transactions=>{
    /*localStorage.clear()
    localStorage.setItem('transaction',JSON.stringify(transaction))*/
  })

  this._router.navigate(['payment-confirmation']);
  
}
}




