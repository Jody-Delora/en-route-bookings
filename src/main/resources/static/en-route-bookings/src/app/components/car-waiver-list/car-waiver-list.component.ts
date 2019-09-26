import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-car-waiver-list',
  templateUrl: './car-waiver-list.component.html',
  styleUrls: ['./car-waiver-list.component.css']
})
export class CarWaiverListComponent implements OnInit {
  @Input() waiverInfo;
  constructor() { }

  ngOnInit() {
  }

}
