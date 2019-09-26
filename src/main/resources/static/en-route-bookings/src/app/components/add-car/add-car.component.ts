import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FlashMessagesService} from 'angular2-flash-messages';
import { CarService } from './../../services/car.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-add-car',
  templateUrl: './add-car.component.html',
  styleUrls: ['./add-car.component.css']
})
export class AddCarComponent implements OnInit {
  waiverList=[];
  carExtraList=[];
  branchList=[];
  supplierLogoFile:any;
  carImageFile:any;
  carImage:any;
  supplierLogo:any;
  transmission:any;
  airConditioning:any
  doorCount:any
  vehicleCategory:any
  vehicleClassSize:any
  vehicleMakeAndModel:any
  passengerCapacity:any
  carSupplierName:any
  
  branchAddress1
  branchSuburb:any
  branchCity:any
  branchProvince:any
  branchTel:any
  branchFax:any
  
  waiverAdminFee:any
  waiverDepositFee:any
  waiverExcessFee:any
  waiverDescription:any
  waiverExcludeDescription:any
  waiverIncludeDescription:any
  waiverType:any
  waiverPrice:any
  
  carExtraType:any
  carExtraPrice:any
  
    constructor(private router:Router,private carService:CarService,private userService:UserService) { }
  
    ngOnInit() {
      this.userService.LoggedIn(true);
    }
    
    back(){
      this.router.navigate(['dashboard']);
    }
  
    getCarImage(event){
      var selectedImage=event.target.files;
      this.carImageFile=selectedImage.item(0);
      this.carImage=event.target.files[0].name;
    }
  
    getSupplierLogo(event){
      var selectedLogo=event.target.files;
      this.supplierLogoFile=selectedLogo.item(0);
      this.supplierLogo = event.target.files[0].name;
    }
  
    addCar(){
      const car={
        "carImage":this.carImage,
        "transmission":this.transmission,
        "airConditioning":this.airConditioning,
        "doorCount":this.doorCount,
        "vehicleCategory":this.vehicleCategory,
        "vehicleClassSize":this.vehicleClassSize,
        "vehicleMakeAndModel":this.vehicleMakeAndModel,
        "passengerCapacity":this.passengerCapacity,
        "carSupplier":{
          "carSupplierName":this.carSupplierName,
          "carSupplierLogo":this.supplierLogo,
          "branch":this.branchList
        },
        "carWaiverDetails":this.waiverList,
        "carExtra":this.carExtraList
      }
      this.carService.addCar(car).subscribe(car=>{})
      this.carService.uploadCarImage(this.carImageFile).subscribe(carImage=>{})
      this.carService.uploadSupplierLogo(this.supplierLogoFile).subscribe(supplierLogo=>{})
    }
  
    addBranch(){
      const branch={
      "branchAddress1":this.branchAddress1,
      "branchSuburb":this.branchSuburb,
      "branchCity":this.branchCity,
      "branchProvince":this.branchProvince,
      "branchTel":this.branchTel,
      "branchFax":this.branchFax
      }
      this.branchList.push(branch);
    
    }
    
    addWaiver(){
      const waiver={
      "waiverAdminFee":this.waiverAdminFee,
      "waiverDepositFee":this.waiverDepositFee,
      "waiverExcessFee":this.waiverExcessFee,
      "waiverDescription":this.waiverDescription,
      "waiverExcludeDescription":this.waiverExcludeDescription,
      "waiverIncludeDescription":this.waiverIncludeDescription,
      "waiverType":this.waiverType,
      "waiverPrice":this.waiverPrice
    }
    this.waiverList.push(waiver)
  }
    addCarExtra(){
      const carExtra={
        "carExtraType":this.carExtraType,
        "carExtraPrice":this.carExtraPrice
      }
      this.carExtraList.push(carExtra);
    }
  
  }
  
