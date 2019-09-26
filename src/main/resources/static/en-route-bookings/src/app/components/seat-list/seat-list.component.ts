import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-seat-list',
  templateUrl: './seat-list.component.html',
  styleUrls: ['./seat-list.component.css']
})
export class SeatListComponent implements OnInit {
  @Input() seatInfo;
  constructor() { }

  ngOnInit() {
  }
  removeSeat(index){
    this.seatInfo.splice(index,1);
    }
}
