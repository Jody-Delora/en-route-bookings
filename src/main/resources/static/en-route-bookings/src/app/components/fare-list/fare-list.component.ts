import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-fare-list',
  templateUrl: './fare-list.component.html',
  styleUrls: ['./fare-list.component.css']
})
export class FareListComponent implements OnInit {
  @Input() fareInfo;
  constructor() { }

  ngOnInit() {
  }

}
