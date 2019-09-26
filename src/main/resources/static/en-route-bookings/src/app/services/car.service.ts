import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable({
  providedIn: 'root'
})
@Injectable()
export class CarService {

  private baseUrl:string='http://localhost:8080/api';
  private headers=new Headers({'Content-Type':'application/json'});
  private options=new RequestOptions({headers:this.headers});
  constructor(private _http:Http) { }

  
  /*getAllCars(){
    return this._http.get(this.baseUrl+'/cars',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }*/
  getAllCars(pickUpLocation:string){
    return this._http.get(this.baseUrl+'/cars/'+pickUpLocation,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }/*
  getSearch(branchName:string,pickUpLocation:string,pickUpDate:Date,pickUpTime:Time,dropOffLocation:string,dropOffDate:Date,dropOffTime:Time){
    return this._http.get(this.baseUrl+'/car/'+branchName+'/car_hire_log/'+pickUpLocation+'/'+pickUpDate+'/'+pickUpTime+'/'+dropOffLocation+'/'+dropOffDate+'/'+dropOffTime+'/carDetails',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }*/

  getCar(id:Number){
    return this._http.get(this.baseUrl+'/car/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  deleteCar(id:Number){
    return this._http.delete(this.baseUrl+'/car/'+id,this.options)
    /*.map((response:Response)=>response.json())
    .catch(this.errorHandler);*/
  }

  addCar(car){
    console.log(car);
    return this._http.post(this.baseUrl+'/car/',JSON.stringify(car),this.options).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }

  uploadCarImage(carImage: any){
    console.log(carImage);
    const formdata: FormData = new FormData();
    formdata.append('carImage', carImage);
    return this._http.post(this.baseUrl+'/uploadCarImage',formdata).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }
  uploadSupplierLogo(supplierLogo: any){
    console.log(supplierLogo);
    const formdata: FormData = new FormData();
    formdata.append('supplierLogo', supplierLogo);
    return this._http.post(this.baseUrl+'/uploadSupplierLogo',formdata).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }

  updateCar(car){
    return this._http.put(this.baseUrl+'/car/',JSON.stringify(car),this.options).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }
  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
  }

}

