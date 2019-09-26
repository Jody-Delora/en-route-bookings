import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hotel-review',
  templateUrl: './hotel-review.component.html',
  styleUrls: ['./hotel-review.component.css']
})
export class HotelReviewComponent implements OnInit {
  hotelInfo: any;
  hotelReservation: any;
  room=[];
  roomLog=[];
  constructor(private _router: Router) { }

  ngOnInit() {
    const hotelInfo = JSON.parse(localStorage.getItem('hotelInfo'));
    this.hotelInfo = hotelInfo;
    const hotelReservation = JSON.parse(localStorage.getItem('hotelReservation'));
    this.hotelReservation = hotelReservation;
    const room = JSON.parse(localStorage.getItem('room'));
    this.room = room;
  }
  selectRoom(i, event, roomType, roomDescription, roomAmenity, roomPrice, room) {
    if (event.target.checked) {
      const roomInfo= {
        "roomType": roomType,
        "roomDescription": roomDescription,
        "roomAmenity": roomAmenity,
        "roomPrice": roomPrice,
        "traveller": this.room[i].traveller
      }
      this.roomLog.push(roomInfo);
      console.log(this.roomLog);
    } else {
      this.roomLog.splice(i,1);
      console.log(this.roomLog);
    }
  }
  next() {
    localStorage.setItem('roomLog',JSON.stringify(this.roomLog))
    this._router.navigate(['hotel-travellers']);
  }
  back(){
    localStorage.removeItem('hotelInfo');
    this._router.navigate(['hotel-selection']);
  }
}

