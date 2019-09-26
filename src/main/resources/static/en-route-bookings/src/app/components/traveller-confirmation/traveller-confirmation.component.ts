import { Component, OnInit,Input } from '@angular/core';
import {Router} from '@angular/router';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component({
  selector: 'app-traveller-confirmation',
  templateUrl: './traveller-confirmation.component.html',
  styleUrls: ['./traveller-confirmation.component.css']
})
export class TravellerConfirmationComponent implements OnInit {
  travellerList:any;
  flightInfo:any;
  traveller:any;
  @Input() travellerInfo;
  
  constructor(private _router:Router,private spinnerService: Ng4LoadingSpinnerService) { }

  ngOnInit() { 
    const traveller=JSON.parse(localStorage.getItem('traveller'));
    const flightInfo=JSON.parse(localStorage.getItem('flightInfo'));
    this.flightInfo=flightInfo;
    this.traveller=traveller;
  }
  next(){
    localStorage.setItem('travellerList', JSON.stringify(this.travellerInfo));
    this.spinnerService.show();
    this._router.navigate(['seat-selection']);
  }
  removeTraveller(index){
    this.travellerInfo.splice(index,1);
    }
 updateDetails(index,firstName,lastName,dateOfBirth,gender,mobile1,mobile2,email1,email2){
  const traveller={
    "firstName":firstName,
    "lastName":lastName,
    "dateOfBirth":dateOfBirth,
    "gender":gender,
    "mobile1":mobile1,
    "mobile2":mobile2,
    "email1":email1,
    "email2":email2
}
  this.travellerInfo[index]=traveller;
 }


}
