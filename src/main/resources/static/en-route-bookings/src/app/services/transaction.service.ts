import { Injectable } from '@angular/core';

import {Http,Response,Headers,RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';


@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private baseUrl:string='http://localhost:8080/api';
  private headers=new Headers({'Content-Type':'application/json'});
  /*private headers=new HttpHeaders({'Content-Type':'application/json'});
  private headers = new HttpHeaders()
  .set('Content-Type','application/json');

  /*private httpOptions = {
    headers: headers,
    params: params,
    withCredentials: true
  };*/

  private options=new RequestOptions({headers:this.headers});
  constructor(private _http:Http) { }
  getAllTransactions(){
    return this._http.get(this.baseUrl+'/transactions',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  
  getTransaction(id:Number){
    return this._http.get(this.baseUrl+'/transaction/'+id,this.options).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }
  getUserTransactions(userId:Number){
    return this._http.get(this.baseUrl+'/userTransaction/'+userId,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  makeTransaction(transaction){
    return this._http.post(this.baseUrl+'/transaction',JSON.stringify(transaction),this.options).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }
  getToken(){
    return this._http.post(this.baseUrl+'/token',this.options).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }
  sendEmail(email){
    return this._http.post(this.baseUrl+'/sendEmail',JSON.stringify(email),this.options).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }
  updateTransaction(transaction){
    return this._http.put(this.baseUrl+'/updateTransaction/',JSON.stringify(transaction),this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  updateSeat(id:Number,seat){
    return this._http.put(this.baseUrl+'/seat/'+id,JSON.stringify(seat),this.options).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }
  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
  }
  /*setter(seat:Seat){
    this.seat=seat;
  }
  getter(){
    return this.seat;
  }*/

}

