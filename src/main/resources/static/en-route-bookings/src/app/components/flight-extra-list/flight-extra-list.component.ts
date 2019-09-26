import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-flight-extra-list',
  templateUrl: './flight-extra-list.component.html',
  styleUrls: ['./flight-extra-list.component.css']
})
export class FlightExtraListComponent implements OnInit {
  @Input() flightExtraInfo;
  constructor() { }

  ngOnInit() {
  }

}
