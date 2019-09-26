import { Component, OnInit,Input  } from '@angular/core';

@Component({
  selector: 'app-branch-list',
  templateUrl: './branch-list.component.html',
  styleUrls: ['./branch-list.component.css']
})
export class BranchListComponent implements OnInit {
  @Input() branchInfo;
  constructor() { }

  ngOnInit() {
  }

}
