import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'en-route-bookings';
  isLoggedIn$: Observable<boolean>;
  constructor(private userService:UserService){}
  
  ngOnInit() {
    this.isLoggedIn$ = this.userService.isLoggedIn;
  }
  
}
