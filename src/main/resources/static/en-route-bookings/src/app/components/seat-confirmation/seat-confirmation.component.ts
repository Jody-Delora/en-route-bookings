import { Component, OnInit,Input } from '@angular/core';
import {Router} from '@angular/router';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component({
  selector: 'app-seat-confirmation',
  templateUrl: './seat-confirmation.component.html',
  styleUrls: ['./seat-confirmation.component.css']
})
export class SeatConfirmationComponent implements OnInit {
  traveller:any;
  @Input() seatInfo;
  travellerList:any;
  constructor(private _router:Router,private spinnerService: Ng4LoadingSpinnerService) { }
  
  ngOnInit() {
    const traveller=JSON.parse(localStorage.getItem('traveller'));
    this.traveller=traveller;
  }
  deSelect(index){
  this.seatInfo.splice(index,1);
  }
  next(){
    localStorage.setItem('seatInfo', JSON.stringify(this.seatInfo));
    this.spinnerService.show();
    this._router.navigate(['flight-extra']);
  }
}

