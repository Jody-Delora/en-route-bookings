import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FlashMessagesService} from 'angular2-flash-messages';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import {AircraftService} from '../../services/aircraft.service';

@Component({
  selector: 'app-travellers',
  templateUrl: './travellers.component.html',
  styleUrls: ['./travellers.component.css']
})
export class TravellersComponent implements OnInit {
  traveller:number;
  firstName:any;
  lastName:any;
  dateOfBirth:any;
  gender:any;
  mobile1:any;
  mobile2:any;
  email1:any;
  email2:any;
  cart:any;
  travellerList=[];
  today = new Date().toJSON().split('T')[0];
  constructor(private _router:Router,private flashMessage:FlashMessagesService,private spinnerService: Ng4LoadingSpinnerService,private aircraftService:AircraftService) { }

  ngOnInit() {
    const traveller=JSON.parse(localStorage.getItem('traveller'));
    this.traveller=traveller;  
    this.spinnerService.hide();
  }
  addTraveller(firstName,lastName,dateOfBirth,gender,mobile1,mobile2,email1,email2){
    const traveller=JSON.parse(localStorage.getItem('traveller'));
    this.traveller=traveller; 
      const travellerInfo={
        "firstName":firstName,
        "lastName":lastName,
        "dateOfBirth":dateOfBirth,
        "gender":gender,
        "mobile1":mobile1,
        "mobile2":mobile2,
        "email1":email1,
        "email2":email2
    }
    if(!this.aircraftService.validateTraveller(travellerInfo)){
      this.flashMessage.show('Please fill in required fields',{cssClass:'alert-danger',timeout:10000});
      return false;
    }else{
    this.travellerList.push(travellerInfo);
    this.firstName="";
    this.lastName="";
    this.dateOfBirth=null;
    this.gender="";
    this.mobile1="";
    this.mobile2="";
    this.email1="";
    this.email2="";
    }
  }
  Back(){
    this._router.navigate(['flight-confirmation']);
  }
  

}

