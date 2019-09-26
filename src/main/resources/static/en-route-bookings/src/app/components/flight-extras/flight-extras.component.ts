import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AircraftService} from '../../services/aircraft.service';
import {FlashMessagesService} from 'angular2-flash-messages';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component({
  selector: 'app-flight-extras',
  templateUrl: './flight-extras.component.html',
  styleUrls: ['./flight-extras.component.css']
})
export class FlightExtrasComponent implements OnInit {
  data:any;
  seatInfo:any;
  flightInfo:any;
  traveller:any;
  travellerInfo:any;
  seatTotal=0;
  taxTotal=0;
  extraQuantity=1;
  flightExtras=[];
  extraSize=0;
  extraTotal:number;
  fareTotal=0;
  grandTotal=0;
  count:number;
  flight:any;
    constructor(private _router:Router,private _aircraftService:AircraftService,private flashMessage:FlashMessagesService,private spinnerService: Ng4LoadingSpinnerService) { }
    
  
    ngOnInit() {
      this.spinnerService.hide();
      const flightInfo=JSON.parse(localStorage.getItem('flightInfo'));
      this.flightInfo=flightInfo; 
      const traveller=JSON.parse(localStorage.getItem('traveller'));
      this.traveller=traveller; 
      const data=JSON.parse(localStorage.getItem('data'));
      this.data=data; 
      const seatInfo=JSON.parse(localStorage.getItem('seatInfo'));
      this.seatInfo=seatInfo; 
      const travellerInfo=JSON.parse(localStorage.getItem('travellerList'));
      this.travellerInfo=travellerInfo; 
      this.taxTotal=flightInfo.passengerSafetyCharge+flightInfo.passengerSecurityCharge+flightInfo.passengerServiceCharge+flightInfo.VAT
      for(let i=0;i<seatInfo.length;i++){
        this.seatTotal+=seatInfo[i].seatPrice;
      }
      this.fareTotal=flightInfo.farePrice*traveller;
  
      this.grandTotal=this.fareTotal+this.seatTotal;
  
       }
      
  back(){
    this.spinnerService.show();
    localStorage.removeItem('seatInfo');
    this._router.navigate(['seat-selection']);
  }
  
  deSelect(index){
    this.flightExtras.splice(index,1);
  
    }
  
  next(){
    if(this.flightExtras.length!=0){
    localStorage.setItem('flightExtras',JSON.stringify(this.flightExtras));
    this.spinnerService.show();
      this._router.navigate(['payment']);
      
    }else{
    
    this.spinnerService.show();
      this._router.navigate(['payment']);
    }
    
  }
  addExtra(extraType,extraDescription,extraPrice){
  const extra={
    "extraType":extraType,
    "extraDescription":extraDescription,
    "extraPrice":extraPrice,
  }
  this.flightExtras.push(extra);
  this.extraSize=this.flightExtras.length;
  
  this.flashMessage.show('Added to cart',{
    cssClass:'alert-success',
    timeout:1000});
  
    const count = this.flightExtras.filter((extras) => extras.extraType==='Flight & bag cover').length;
    this.count=count;
    this.extraTotal=0;
    for(let i=0;i<this.extraSize;i++){
      this.extraTotal+=this.flightExtras[i].extraPrice;
      
    } 
    this.grandTotal=this.fareTotal+this.seatTotal+this.extraTotal;
  }
  
  }
  