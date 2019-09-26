import { Component, OnInit } from '@angular/core';
import { TransactionService } from './../../services/transaction.service';
import {Router} from '@angular/router';
import * as decode from 'jwt-decode';

@Component({
  selector: 'app-driver-details',
  templateUrl: './driver-details.component.html',
  styleUrls: ['./driver-details.component.css']
})
export class DriverDetailsComponent implements OnInit {
  carInfo:any;
  carHireInfo:any;
  carExtra:any;
  transaction:any;
  extraTotal=0;
  grandTotal=0;
  token:any;
    constructor(private _router:Router,private transactionService:TransactionService) { }
  
    ngOnInit() {
      const carInfo=JSON.parse(localStorage.getItem('carInfo'));
      this.carInfo=carInfo; 
  
      const carHireInfo=JSON.parse(localStorage.getItem('carHireInfo'));
      this.carHireInfo=carHireInfo; 
  
      const carExtra=JSON.parse(localStorage.getItem('carExtra'));
      this.carExtra=carExtra;
  
      const token=localStorage.getItem('encode_token');
      this.token=token;
  
      for(let i=0;i<carExtra.length;i++){
        this.extraTotal+=carExtra[i].carExtraPrice;
      } 
      /*for(let i=0;i<carInfo.length;i++){*/
        this.grandTotal=this.extraTotal+carInfo.waiverPrice;
      /*} */
    }
  addDriverInfo(title,firstName,lastName,age,contactName,personIsTravelling,email,cellPhone,homePhone,workPhone,address1,address2,cityOrTown,postalCode,province,country,SAIdNo){
  const driverDetails={
  "title":title,
  "firstName":firstName,
  "lastName":lastName,
  "age":age
  }
  if(this.token==null){
    this.transaction={
      "transactionDate":Date.now(),
      "email":email,
      "carHireLog":{
        "carImage":this.carInfo.carImage,
        "transmission":this.carInfo.transmission,
        "doorCount":this.carInfo.doorCount,
        "airConditioning":this.carInfo.airConditioning,
        "vehicleCategory":this.carInfo.vehicleCategory,
        "vehicleClassSize":this.carInfo.vehicleClassSize,
        "vehicleMakeAndModel":this.carInfo.vehicleMakeAndModel,
        "passengerCapacity":this.carInfo.passengerCapacity,
        "dropOffAddress1":this.carInfo.dropOffInfo.dropOffAddress1,
        "dropOffSuburb":this.carInfo.dropOffInfo.dropOffSuburb,
        "dropOffCity":this.carInfo.dropOffInfo.dropOffCity,
        "dropOffProvince":this.carInfo.dropOffInfo.dropOffProvince,
        "dropOffTel":this.carInfo.dropOffInfo.dropOffTel,
        "dropOffDate":this.carInfo.dropOffInfo.dropOffDate,
        "dropOffTime":this.carInfo.dropOffInfo.dropOffTime,
        "pickUpAddress1":this.carInfo.pickUpInfo.pickUpAddress1,
        "pickUpSuburb":this.carInfo.pickUpInfo.pickUpSuburb,
        "pickUpCity":this.carInfo.pickUpInfo.pickUpCity,
        "pickUpProvince":this.carInfo.pickUpInfo.pickUpProvince,
        "pickUpTel":this.carInfo.pickUpInfo.pickUpTel,
        "pickUpDate":this.carInfo.pickUpInfo.pickUpDate,
        "pickUpTime":this.carInfo.pickUpInfo.pickUpTime,
        "waiverType":this.carInfo.waiverType,
        "waiverDescription":this.carInfo.waiverDescription,
        "waiverExcludeDescription":this.carInfo.waiverExcludeDescription,
        "waiverIncludeDescription":this.carInfo.waiverIncludeDescription,
        "waiverAdminFee":this.carInfo.waiverAdminFee,
        "waiverDepositFee":this.carInfo.waiverDepositFee,
        "waiverExcessFee":this.carInfo.waiverExcessFee,
        "waiverPrice":this.carInfo.waiverPrice,
        "extraTotal":this.extraTotal,
        "grandTotal":this.grandTotal,
        "carSupplierLogo":this.carInfo.supplierLogo,
        "carSupplierName":this.carInfo.supplierName,
        "driverDetails":{
          "title":title,
          "firstName":firstName,
          "lastName":lastName,
          "age":age,
          "primaryContact":{
            "title":title,
            "contactName":contactName,
            "personIsTravelling":personIsTravelling,
            "email":email,
            "cellPhone":cellPhone,
            "homePhone":homePhone,
            "workPhone":workPhone,
            "address1":address1,
            "address2":address2,
            "cityOrTown":cityOrTown,
            "province":province,
            "postalCode":postalCode,
            "country":country,
            "saIdNo":SAIdNo
          }
        },
        "carExtraLog":this.carExtra
      }
      }
  }else{
    this.transaction={
      "transactionDate":Date.now(),
      "userId":decode(this.token).userId,
      "email":decode(this.token).sub,
      "carHireLog":{
        "carImage":this.carInfo.carImage,
        "transmission":this.carInfo.transmission,
        "doorCount":this.carInfo.doorCount,
        "airConditioning":this.carInfo.airConditioning,
        "vehicleCategory":this.carInfo.vehicleCategory,
        "vehicleClassSize":this.carInfo.vehicleClassSize,
        "vehicleMakeAndModel":this.carInfo.vehicleMakeAndModel,
        "passengerCapacity":this.carInfo.passengerCapacity,
        "dropOffAddress1":this.carInfo.dropOffInfo.dropOffAddress1,
        "dropOffSuburb":this.carInfo.dropOffInfo.dropOffSuburb,
        "dropOffCity":this.carInfo.dropOffInfo.dropOffCity,
        "dropOffProvince":this.carInfo.dropOffInfo.dropOffProvince,
        "dropOffTel":this.carInfo.dropOffInfo.dropOffTel,
        "dropOffDate":this.carInfo.dropOffInfo.dropOffDate,
        "dropOffTime":this.carInfo.dropOffInfo.dropOffTime,
        "pickUpAddress1":this.carInfo.pickUpInfo.pickUpAddress1,
        "pickUpSuburb":this.carInfo.pickUpInfo.pickUpSuburb,
        "pickUpCity":this.carInfo.pickUpInfo.pickUpCity,
        "pickUpProvince":this.carInfo.pickUpInfo.pickUpProvince,
        "pickUpTel":this.carInfo.pickUpInfo.pickUpTel,
        "pickUpDate":this.carInfo.pickUpInfo.pickUpDate,
        "pickUpTime":this.carInfo.pickUpInfo.pickUpTime,
        "waiverType":this.carInfo.waiverType,
        "waiverDescription":this.carInfo.waiverDescription,
        "waiverExcludeDescription":this.carInfo.waiverExcludeDescription,
        "waiverIncludeDescription":this.carInfo.waiverIncludeDescription,
        "waiverAdminFee":this.carInfo.waiverAdminFee,
        "waiverDepositFee":this.carInfo.waiverDepositFee,
        "waiverExcessFee":this.carInfo.waiverExcessFee,
        "waiverPrice":this.carInfo.waiverPrice,
        "extraTotal":this.extraTotal,
        "grandTotal":this.grandTotal,
        "carSupplierLogo":this.carInfo.supplierLogo,
        "carSupplierName":this.carInfo.supplierName,
        "driverDetails":{
          "title":title,
          "firstName":firstName,
          "lastName":lastName,
          "age":age,
          "primaryContact":{
            "title":title,
            "contactName":contactName,
            "personIsTravelling":personIsTravelling,
            "email":email,
            "cellPhone":cellPhone,
            "homePhone":homePhone,
            "workPhone":workPhone,
            "address1":address1,
            "address2":address2,
            "cityOrTown":cityOrTown,
            "province":province,
            "postalCode":postalCode,
            "country":country,
            "saIdNo":SAIdNo
          }
        },
        "carExtraLog":this.carExtra
      }
      }
        
  }
  console.log(this.transaction);
  this.transactionService.makeTransaction(this.transaction).subscribe((transactions)=>{
  
  });
  this._router.navigate(['car-payment']);
  }
  back(){
    localStorage.removeItem('carExtra')
    this._router.navigate(['car-review'])
  }
  }
  
