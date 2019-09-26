import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-car-payment',
  templateUrl: './car-payment.component.html',
  styleUrls: ['./car-payment.component.css']
})
export class CarPaymentComponent implements OnInit {
  carInfo:any;
  carHireInfo:any;
  car:any;
  carExtras=[]
  constructor() { }

  ngOnInit() {
    const carInfo=JSON.parse(localStorage.getItem('carInfo'));
    this.carInfo=carInfo; 
    const carHireInfo=JSON.parse(localStorage.getItem('carHireInfo'));
    this.carHireInfo=carHireInfo; 
    const car=JSON.parse(localStorage.getItem('car'));
    this.car=car;
  }

}
