import { Component, OnInit } from '@angular/core';
import {AircraftService} from '../../services/aircraft.service';
import {Router} from '@angular/router';
import {FlashMessagesService} from 'angular2-flash-messages';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component({
  selector: 'app-seat-selection',
  templateUrl: './seat-selection.component.html',
  styleUrls: ['./seat-selection.component.css']
})
export class SeatSelectionComponent implements OnInit {
  data:any;
  flightInfo:any;
  seat_row:number;
  seat_column:string;
  seat_type:string;
  seat_price:string;
  seatSelection=[];
  travellerList:any;
  traveller:any;
  value;
  constructor(private _aircraftService:AircraftService,private _router:Router,private flashMessage:FlashMessagesService,private spinnerService: Ng4LoadingSpinnerService) { }
  
    ngOnInit() {
      const data=JSON.parse(localStorage.getItem('data'));
      this.data=data;
      const flightInfo=JSON.parse(localStorage.getItem('flightInfo'));
      this.flightInfo=flightInfo;
      const travellerList=JSON.parse(localStorage.getItem('travellerList'));
      this.travellerList=travellerList;
      const traveller=JSON.parse(localStorage.getItem('traveller'));
      this.traveller=traveller;
      this.spinnerService.hide();
      
    }
    selectSeat(id,seatRow,seatColumn,seatType,seatPosition,seatPrice){ 
      const seat={
        "id":id,
        "seatRow":seatRow,
        "seatColumn":seatColumn,
        "seatType":seatType,
        "seatPosition":seatPosition,
        "seatPrice":seatPrice
      }
  
  
    if(this.seatSelection.length!=this.traveller){
      this.seatSelection.push(seat);
     
      let count = this.seatSelection.filter((seats) => seats.seatColumn+seats.seatRow===seat.seatColumn+seat.seatRow).length;
      if(count==this.traveller&&this.traveller!=1){
        this.seatSelection.pop();
        this.flashMessage.show('You cannot select the same seat twice',{
          cssClass:'alert-danger',
          timeout:2000});
      }
  
     }else{
      this.flashMessage.show('You can only select '+this.traveller+' seat/s',{
        cssClass:'alert-danger',
        timeout:2000});
     }
      
    }
    back(){
      localStorage.removeItem('travellerList');
      localStorage.removeItem('seatInfo');
      this._router.navigate(['travellers']);
    }
   
  }
  