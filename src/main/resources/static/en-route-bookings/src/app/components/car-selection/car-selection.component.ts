import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-car-selection',
  templateUrl: './car-selection.component.html',
  styleUrls: ['./car-selection.component.css']
})
export class CarSelectionComponent implements OnInit {
  car:any;
  pickUpLocation:any;
  carHireInfo:any;
  carHireList=[];
  pickUpPoint:any;
  dropOffPoint:any;
  dropOffInfo:any;
  pickUpInfo:any;
    constructor(private _router:Router) { }
  
    ngOnInit() {
      const car=JSON.parse(localStorage.getItem('car'));
      this.car=car;
      const carHireInfo=JSON.parse(localStorage.getItem('carHireInfo'));
      this.carHireInfo=carHireInfo; 
      /*this.pickUpLocation=car.branch.filter((extras) => extras.branchCity===this.carHireInfo.pickUpLocation);
      console.log(this.pickUpLocation);*/
    }
  selectWaiver(vehicleMakeAndModel,carImage,vehicleCategory,vehicleClassSize,transmission,airConditioning,doorCount,passengerCapacity,carExtra,waiverType,waiverDescription,waiverExcludeDescription,waiverIncludeDescription,waiverAdminFee,waiverDepositFee,waiverExcessFee,waiverPrice,supplierLogo,supplierName,branch){
    const pickUpPoint = branch.filter((branch) => branch.branchSuburb===this.carHireInfo.pickUpLocation);
    this.pickUpPoint=pickUpPoint;
    for(let branch of pickUpPoint){
      const pickUpInfo={
        "pickUpAddress1":branch.branchAddress1,
        "pickUpSuburb":branch.branchSuburb,
        "pickUpCity":branch.branchCity,
        "pickUpFax":branch.branchFax,
        "pickUpProvince":branch.branchProvince,
        "pickUpTel":branch.branchTel,
        "pickUpDate":this.carHireInfo.pickUpDate,
        "pickUpTime":this.carHireInfo.pickUpTime
      } 
      this.pickUpInfo=pickUpInfo;
    }
    const dropOffPoint = branch.filter((branch) => branch.branchSuburb==this.carHireInfo.dropOffLocation);
    this.dropOffPoint=dropOffPoint;
  
    for(let branch of dropOffPoint){
      const dropOffInfo={
        "dropOffAddress1":branch.branchAddress1,
        "dropOffSuburb":branch.branchSuburb,
        "dropOffCity":branch.branchCity,
        "dropOffFax":branch.branchFax,
        "dropOffProvince":branch.branchProvince,
        "dropOffTel":branch.branchTel,
        "dropOffDate":this.carHireInfo.dropOffDate,
        "dropOffTime":this.carHireInfo.dropOffTime
      } 
      this.dropOffInfo=dropOffInfo; 
    }
  
    const carInfo={
    "vehicleMakeAndModel":vehicleMakeAndModel,
    "carImage":carImage,
    "vehicleCategory":vehicleCategory,
    "vehicleClassSize":vehicleClassSize,
    "transmission":transmission,
    "airConditioning":airConditioning,
    "doorCount":doorCount,
    "passengerCapacity":passengerCapacity,
    "carExtra":carExtra,
    "waiverType":waiverType,
    "waiverDescription":waiverDescription,
    "waiverExcludeDescription":waiverExcludeDescription,
    "waiverIncludeDescription":waiverIncludeDescription,
    "waiverAdminFee":waiverAdminFee,
    "waiverDepositFee":waiverDepositFee,
    "waiverExcessFee":waiverExcessFee,
    "waiverPrice":waiverPrice,
    "supplierLogo":supplierLogo,
    "supplierName":supplierName,
    "pickUpInfo":this.pickUpInfo,
    "dropOffInfo":this.dropOffInfo
  }
  //this.carHireList.push(carInfo);
  localStorage.setItem('carInfo', JSON.stringify(carInfo));
  this._router.navigate(['car-review']);
  
  }
  }
  
