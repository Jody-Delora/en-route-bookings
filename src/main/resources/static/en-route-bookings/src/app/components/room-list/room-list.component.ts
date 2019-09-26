import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {
  @Input() roomInfo;
  constructor() { }

  ngOnInit() {
  }

}
