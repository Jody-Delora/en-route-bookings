import { Component, OnInit } from '@angular/core';
import {AircraftService} from '../../services/aircraft.service';
import {Router} from '@angular/router';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component({
  selector: 'app-flight-selection',
  templateUrl: './flight-selection.component.html',
  styleUrls: ['./flight-selection.component.css']
})
export class FlightSelectionComponent implements OnInit {
  data:any;
  traveller:any;
  sum:number;
  flight:any;
  constructor(private _aircraftService:AircraftService,private _router:Router,private spinnerService: Ng4LoadingSpinnerService) { }
  ngOnInit() {
    const data=JSON.parse(localStorage.getItem('data'));
    const traveller=parseInt(localStorage.getItem('traveller'));
    this.traveller=traveller;
    this.data=data; 
    this.spinnerService.hide();
    console.log(data[0].aircraftName);
  }
 
  selectedFare(id,departureDate,departureTime,departureLocation,arrivalDate,arrivalTime,arrivalLocation,flightNo,aircraftName,carrierName,
    carrierLogo,className,fareType,farePrice,passengerSafetyCharge,passengerSecurityCharge,passengerServiceCharge,
    VAT){
    const flight={
          "id":id,
          "departureDate":departureDate,
          "departureTime":departureTime,
          "departureLocation":departureLocation,
          "arrivalDate":arrivalDate,
          "arrivalTime":arrivalTime,
          "arrivalLocation":arrivalLocation,
          "flightNo":flightNo,
          "aircraftName":aircraftName,
          "carrierName":carrierName,
          "carrierLogo":carrierLogo,
          "className":className,
          "fareType":fareType,
          "farePrice":farePrice,
          "passengerSafetyCharge":passengerSafetyCharge,
          "passengerSecurityCharge":passengerSecurityCharge,
          "passengerServiceCharge":passengerServiceCharge,
          "VAT":VAT,
       
      }

    this.flight=Object.assign(flight);
    localStorage.setItem('flightInfo', JSON.stringify(this.flight));
    this.spinnerService.show();
    this._router.navigate(['/flight-confirmation']);
  }
  onBack(){
    localStorage.removeItem('flightInfo');
    this.spinnerService.show();
    this._router.navigate(['/']);
  }
    
    
 
}

