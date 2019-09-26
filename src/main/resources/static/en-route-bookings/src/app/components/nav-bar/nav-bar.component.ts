import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { FlashMessagesService } from 'angular2-flash-messages';


@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private userService:UserService,private router:Router,private flashMessage: FlashMessagesService) { }

  ngOnInit() {
    
  }
  onSignOut(){
    
    localStorage.clear();
    this.flashMessage.show('You are now logged out',{
      cssClass:'alert-success',
      timeout:3000
    });
    this.router.navigate(['/']); 
    return false;
  }

}
