import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {
  @Input() flightInfo;
  constructor() { }

  ngOnInit() {
  }

}
