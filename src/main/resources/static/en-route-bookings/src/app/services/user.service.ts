import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import { Observable } from 'rxjs'
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject } from 'rxjs';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import * as decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})

export class UserService {
  authToken:any;
  data:any;
  user_info:any;
  Token:any;
  private baseUrl:string='http://localhost:8080/api';
  private headers=new Headers({
    'Content-Type':'application/json',
    'Access-Control-Allow-Origin':'*',
    'Access-Control-Allow-Methods':'GET,POST,PATCH,PUT,DELETE,OPTIONS',
    'Access-Control-Allow-Headers':'Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With'
  });
  private options=new RequestOptions({headers:this.headers});

  private loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  constructor(private _http:Http,public jwtHelper: JwtHelperService) { }

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  LoggedIn(ans:boolean){
    return this.loggedIn.next(ans);
  }

  public isAuthenticated(): boolean {
    const token = localStorage.getItem('encode_token');
    if (token == null){
      return false;
    }
    else{ 
      return this.jwtHelper.isTokenExpired(token);
    }
  }

  getAllUsers(){
    return this._http.get(this.baseUrl+'/secured/users',this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getUser(id:Number,Token){
    this.headers.append('Authorization','Bearer '+Token);
    /*this.headers.append('Content-Type','application/json');*/
    return this._http.get(this.baseUrl+'/user/'+id,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  deleteUser(id:Number){
    return this._http.delete(this.baseUrl+'/secured/user/'+id,this.options)
    .map((response:Response)=>response.json())
    .catch(this.errorHandler); 
  }

  addUser(user){
    return this._http.post(this.baseUrl+'/user/',JSON.stringify(user),this.options).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }
  updateUser(user){
    return this._http.put(this.baseUrl+'/updateUser/',JSON.stringify(user),this.options).map((response:Response)=>response.text())
    .catch(this.errorHandler);
  }
  
  authenticateUser(user){
    /*this.headers.append('Content-Type','application/json');*/
    return this._http.post(this.baseUrl+'/login/',JSON.stringify(user),this.options).map(res=>res.text())
    .catch(this.errorHandler);
  }

  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
  }

}
