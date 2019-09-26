import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-car-review',
  templateUrl: './car-review.component.html',
  styleUrls: ['./car-review.component.css']
})
export class CarReviewComponent implements OnInit {
  carInfo:any;
  carHireInfo:any;
  car:any;
  carExtras=[]
  count:any;
  branch;
  constructor(private _router:Router) { }

  ngOnInit() {
    const carInfo=JSON.parse(localStorage.getItem('carInfo'));
    this.carInfo=carInfo; 
    const carHireInfo=JSON.parse(localStorage.getItem('carHireInfo'));
    this.carHireInfo=carHireInfo; 
    const car=JSON.parse(localStorage.getItem('car'));
    this.car=car;
    const branch=JSON.parse(localStorage.getItem('branch'));
    this.branch=branch;
  }
next(){
  localStorage.setItem('carExtra',JSON.stringify(this.carExtras));
  this._router.navigate(['driver-details']);
}
back(){
  localStorage.removeItem('carInfo');
  this._router.navigate(['car-selection']);
}
addExtra(event,carExtraType,carExtraPrice){
  if(event.target.checked){
    const carExtra={
    "carExtraType":carExtraType,
    "carExtraPrice":carExtraPrice
    }
    this.carExtras.push(carExtra);
    const count = this.carExtras.filter((extras) => extras.carExtraType===carExtraType).length;
    this.count=count;
    if(count>1){
      this.carExtras.pop();
    }
  }else{
    this.carExtras.pop();
  }
}
}
