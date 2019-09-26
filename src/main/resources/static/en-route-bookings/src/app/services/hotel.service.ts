import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable({
  providedIn: 'root'
})

export class HotelService {

  private baseUrl:string='http://localhost:8080/api';
  private headers=new Headers({'Content-Type':'application/json'});
  private options=new RequestOptions({headers:this.headers});

  constructor(private _http:Http) { }

  getAllHotels(){
    return this._http.get(this.baseUrl+'/hotels',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  getSearch(hotelCity:string,hotelProvince:string,locationType:string,propertyType:string,hotelName:string,hotelChain:string,starRating:string){
    return this._http.get(this.baseUrl+'/hotels/'+hotelCity+'/'+hotelProvince+'/'+locationType+'/'+propertyType+'/'+hotelName+'/'+hotelChain+'/'+starRating,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getHotel(id:Number){
    return this._http.get(this.baseUrl+'/hotel/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  deleteHotel(id:Number){
    return this._http.delete(this.baseUrl+'/hotel/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  addHotel(hotel){
    console.log(hotel);
    return this._http.post(this.baseUrl+'/hotel/',JSON.stringify(hotel),this.options).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }

  uploadHotelImages(hotelImages:any){
    const formdata: FormData = new FormData();
    formdata.append('hotelImages', hotelImages);
    return this._http.post(this.baseUrl+'/uploadHotelImages',formdata).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }
  
  updateHotel(hotel){
    return this._http.put(this.baseUrl+'/secured/hotel/',JSON.stringify(hotel),this.options).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }
 
  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
  }

}

