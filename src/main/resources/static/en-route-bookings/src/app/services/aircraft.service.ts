import { Injectable } from '@angular/core';

import {Http,Response,Headers,RequestOptions} from '@angular/http';

import {Observable} from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable({
  providedIn: 'root'
})
export class AircraftService {
  data:any;
  traveller:number;
  cart:any;

  private baseUrl:string='http://localhost:8080/api';
  private headers=new Headers({
    'Content-Type':'application/json'
  });

  private options=new RequestOptions({
    headers:this.headers
  });
  
  constructor(private _http:Http) { }

  
  getAllAircrafts(){
    return this._http.get(this.baseUrl+'/aircrafts',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  getSearch(departureLocation:string,arrivalLocation:string,departureDate:Date,className:string){
    return this._http.get(this.baseUrl+'/flight/'+departureLocation+'/'+arrivalLocation+'/'+departureDate+'/class/'+className+'/aircrafts',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getAircraft(id:Number){
    return this._http.get(this.baseUrl+'/aircraft/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  deleteAircraft(id:Number){
    return this._http.delete(this.baseUrl+'/aircraft/'+id,this.options)
    /*.map((response:Response)=>response.json())
    .catch(this.errorHandler);*/
  }

  addAircraft(aircraft){
    return this._http.post(this.baseUrl+'/aircraft',JSON.stringify(aircraft),this.options).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }

  uploadCarrierLogo(carrierLogo: any){
    console.log(carrierLogo);
    const formdata: FormData = new FormData();
    formdata.append('carrierLogo', carrierLogo);
    return this._http.post(this.baseUrl+'/uploadCarrierLogo',formdata).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }

  uploadFlightImages(flightImage: any){
    console.log(flightImage);
    const formdata: FormData = new FormData();
    formdata.append('flightImage', flightImage);
    return this._http.post(this.baseUrl+'/uploadFlightImages',formdata).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }

  updateAircraft(aircraft){
    return this._http.put(this.baseUrl+'/secured/updateAircraft/',JSON.stringify(aircraft),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateSeat(seatId,flightId,seat){
    return this._http.put(this.baseUrl+'/seat/'+seatId+'/aircraft/'+flightId,JSON.stringify(seat),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
  }
  storeFlightData(data,traveller){
    localStorage.setItem('data', JSON.stringify(data));
    localStorage.setItem('traveller', traveller);
    this.data=data;
    this.traveller=traveller;
 
  }
  validateTraveller(travellerInfo){
    if(travellerInfo.firstName==undefined||travellerInfo.lastName==undefined||travellerInfo.mobile1==undefined||travellerInfo.dateOfBirth==undefined||travellerInfo.gender==undefined||travellerInfo.email1==undefined){
    return false;
    } else{
      return true;
    }
  }
  storeCart(cart){
    localStorage.setItem('data', JSON.stringify(cart));
    this.cart=cart;
  }
  clearStorage(){
    localStorage.clear();
  }  

}

