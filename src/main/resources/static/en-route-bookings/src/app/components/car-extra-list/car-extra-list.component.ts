import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-car-extra-list',
  templateUrl: './car-extra-list.component.html',
  styleUrls: ['./car-extra-list.component.css']
})
export class CarExtraListComponent implements OnInit {
  @Input() carExtraInfo;
  constructor() { }

  ngOnInit() {
  }

}
