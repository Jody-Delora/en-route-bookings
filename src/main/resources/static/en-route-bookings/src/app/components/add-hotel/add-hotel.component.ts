import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FlashMessagesService} from 'angular2-flash-messages';
import { HotelService } from './../../services/hotel.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-add-hotel',
  templateUrl: './add-hotel.component.html',
  styleUrls: ['./add-hotel.component.css']
})
export class AddHotelComponent implements OnInit {
  roomList=[]
  hotelImages=[]
  hotelImageFiles:any;
  hotelName:any
  hotelDescription:any
  hotelAddress1:any
  hotelSuburb:any
  hotelCity:any
  hotelProvince:any
  hotelCountry:any
  hotelChain:any
  locationType:any
  propertyType:any
  propertyAmenities:any
  starRating:any
    constructor(private router:Router, private hotelService:HotelService,private userService:UserService) { }
  
  ngOnInit() {
    this.userService.LoggedIn(true);
    }
  back(){
    this.router.navigate(['dashboard']);
  }
  getHotelImages(event){
    this.hotelImageFiles=event.target.files;
    for (var i = 0; i < event.target.files.length; i++) { 
        var name = event.target.files[i].name;
        var hotelImage=name;
        this.hotelImages.push(hotelImage);
      }
  
  }
  addHotel(){
  
      const hotel={
      "hotelName":this.hotelName,
      "hotelImage":this.hotelImages,
      "hotelDescription":this.hotelDescription,
      "hotelAddress1":this.hotelAddress1,
      "hotelSuburb":this.hotelSuburb,
      "hotelCity":this.hotelCity,
      "hotelProvince":this.hotelProvince,
      "hotelCountry":this.hotelCountry,
      "hotelChain":this.hotelChain,
      "locationType":this.locationType,
      "propertyType":this.propertyType,
      "propertyAmenities":this.propertyAmenities,
      "starRating":this.starRating,
      "room":this.roomList
    }
  
    this.hotelService.addHotel(hotel).subscribe(hotel=>{})
    for (var i = 0; i < this.hotelImageFiles.length; i++) { 
      this.hotelService.uploadHotelImages(this.hotelImageFiles[i]).subscribe(hotelImages=>{});
    }
    
  }
  addRoom(roomType,roomDescription,roomAmenity,roomPrice){
    const room={
    "roomType":roomType,
    "roomDescription":roomDescription,
    "roomAmenity":roomAmenity,
    "roomPrice":roomPrice
    }
    this.roomList.push(room)
  }
  }
  