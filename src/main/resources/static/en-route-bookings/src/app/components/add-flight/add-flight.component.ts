import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FlashMessagesService} from 'angular2-flash-messages';
import {AircraftService} from '../../services/aircraft.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {
  flightList=[] 
  airlineClass:any;
  seatList=[]
  fareList=[]
  extraList=[]
  carrierLogoFile:any;
  extraImagesFile:any;
  
  carrierLogo:any;
  extraImage:any;
  
  today = new Date().toJSON().split('T')[0];
    constructor(private router:Router,private flashMessage:FlashMessagesService,private aircraftService:AircraftService,private userService:UserService) { }
  
    ngOnInit() {
      this.userService.LoggedIn(true);
    }
    back(){
      this.router.navigate(['dashboard']);
    }
    getCarrierLogo(event) {
      var selectedFiles=event.target.files;
      this.carrierLogoFile=selectedFiles.item(0);
      this.carrierLogo=event.target.files[0].name;
    }
  
      getExtraLogo(event) {
        var selectedImage=event.target.files;
        this.extraImagesFile=selectedImage.item(0);
        this.extraImage=event.target.files[0].name;
  
    }
    
    addAircraft(aircraftName,carrierName){
      const aircraft={
        "aircraftName":aircraftName,
        "carrierName":carrierName,
        "carrierLogo":this.carrierLogo,
        "flightSchedule":this.flightList
      }
      console.log(aircraft);
      this.aircraftService.addAircraft(aircraft).subscribe(aircratft=>{});
      this.aircraftService.uploadCarrierLogo(this.carrierLogoFile).subscribe(aircratft=>{});
      
  
    }
    addFlight(arrivalLocation,arrivalDate,arrivalTime,departureLocation,departureDate,departureTime,flightNo){
      const flight={
        "arrivalLocation":arrivalLocation,
        "arrivalDate":arrivalDate,
        "arrivalTime":arrivalTime.concat(':00'),
        "departureLocation":departureLocation,
        "departureDate":departureDate,
        "departureTime":departureTime.concat(':00'),
        "flightNo":flightNo,
        "airlineClass":this.airlineClass,
        "flightExtra":this.extraList
      }
      this.flightList.push(flight)
    }
    addAirlineClass(airlineClassName){
      const airlineClass={
        "className":airlineClassName,
        "fare":this.fareList,
        "seatPlan":this.seatList
      }
      this.airlineClass=Object.assign(airlineClass);
      /*this.classList.push(airlineClass);*/
    }
    addFare(fareType,farePrice,maxSeats,checkedBaggage,
      flightCancellation,flightChanges,foodAndBeverages,VAT,passengerSafetyCharge,
      passengerSecurityCharge,passengerServiceCharge){
      const fare={
        "fareType":fareType,
        "farePrice":farePrice,
        "maxSeats":maxSeats,
        "checkedBaggage":checkedBaggage,
        "flightCancellation":flightCancellation,
        "flightChanges":flightChanges,
        "foodAndBeverages":foodAndBeverages,
        "VAT":VAT,
        "passengerSafetyCharge":passengerSafetyCharge,
        "passengerSecurityCharge":passengerSecurityCharge,
        "passengerServiceCharge":passengerServiceCharge
     
      }
      this.fareList.push(fare)
    }
  addSeat(seatColumn,seatRow,seatType,seatPosition,seatPrice){
    const seat={
      "seatColumn":seatColumn,
      "seatRow":seatRow,
      "seatType":seatType,
      "seatPosition":seatPosition,
      "seatPrice":seatPrice
    }
  this.seatList.push(seat);
  }
  addExtra(extraType,extraDescription,extraPrice){
    const extra={
      "extraType":extraType,
      "extraDescription":extraDescription,
      "extraPrice":extraPrice,
      "extraImage":this.extraImage
    }
    this.extraList.push(extra)
    this.aircraftService.uploadFlightImages(this.extraImagesFile).subscribe(extraImages=>{});
  }
  }
  
