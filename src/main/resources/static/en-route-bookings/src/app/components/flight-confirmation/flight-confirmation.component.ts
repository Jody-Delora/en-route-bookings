import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AircraftService} from '../../services/aircraft.service';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component({
  selector: 'app-flight-confirmation',
  templateUrl: './flight-confirmation.component.html',
  styleUrls: ['./flight-confirmation.component.css']
})
export class FlightConfirmationComponent implements OnInit {
  flightInfo:any;
  traveller:number;
  sum:number;
  fareCost:number;
  value_added_tax:number;
  passenger_safety_charge:number;
  passenger_security_charge:number;
  passenger_service_charge:number;
  taxFeesCost:number;
  total:number;

  
  constructor(private _router:Router,private _aircraftService:AircraftService,private spinnerService: Ng4LoadingSpinnerService) { }

  

  ngOnInit() {
    const flightInfo=JSON.parse(localStorage.getItem('flightInfo'));
    const traveller=JSON.parse(localStorage.getItem('traveller'));
    this.flightInfo=flightInfo;  
    this.traveller=traveller;
    this.spinnerService.hide();

  }
  travellerPage(){
    this.spinnerService.show();
    this._router.navigate(['/travellers']);
  }
  onChange(){
    localStorage.removeItem('flightInfo');
    this.spinnerService.show();
    this._router.navigate(['/flight-selection']);
  
  }

}

