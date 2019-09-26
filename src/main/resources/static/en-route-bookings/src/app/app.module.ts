import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import {RouterModule,Routes, CanActivate} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { FlashMessagesModule } from 'angular2-flash-messages';
import { AppComponent } from './app.component';
import { AddCarComponent } from './components/add-car/add-car.component';
import { AddFlightComponent } from './components/add-flight/add-flight.component';
import { AddHotelComponent } from './components/add-hotel/add-hotel.component';
import { BranchListComponent } from './components/branch-list/branch-list.component';
import { CarExtraListComponent } from './components/car-extra-list/car-extra-list.component';
import { CarPaymentComponent } from './components/car-payment/car-payment.component';
import { CarReviewComponent } from './components/car-review/car-review.component';
import { CarSelectionComponent } from './components/car-selection/car-selection.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { DriverDetailsComponent } from './components/driver-details/driver-details.component';
import { FareListComponent } from './components/fare-list/fare-list.component';
import { FlightConfirmationComponent } from './components/flight-confirmation/flight-confirmation.component';
import { FlightExtraListComponent } from './components/flight-extra-list/flight-extra-list.component';
import { FlightExtrasComponent } from './components/flight-extras/flight-extras.component';
import { FlightListComponent } from './components/flight-list/flight-list.component';
import { FlightSelectionComponent } from './components/flight-selection/flight-selection.component';
import { IndexComponent } from './components/index/index.component';
import { HotelConfirmationComponent } from './components/hotel-confirmation/hotel-confirmation.component';
import { HotelReviewComponent } from './components/hotel-review/hotel-review.component';
import { HotelSelectionComponent } from './components/hotel-selection/hotel-selection.component';
import { HotelTravellersComponent } from './components/hotel-travellers/hotel-travellers.component';
import { LoginComponent } from './components/login/login.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { FlightPaymentComponent } from './components/flight-payment/flight-payment.component';
import { PaymentConfirmationComponent } from './components/payment-confirmation/payment-confirmation.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RoomListComponent } from './components/room-list/room-list.component';
import { SeatConfirmationComponent } from './components/seat-confirmation/seat-confirmation.component';
import { SeatListComponent } from './components/seat-list/seat-list.component';
import { SeatSelectionComponent } from './components/seat-selection/seat-selection.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { TravellerConfirmationComponent } from './components/traveller-confirmation/traveller-confirmation.component';
import { TravellersComponent } from './components/travellers/travellers.component';
import { CarWaiverListComponent } from './components/car-waiver-list/car-waiver-list.component';
import { AircraftService } from './services/aircraft.service';
import { UserService } from './services/user.service';
import { CarService } from './services/car.service';
import { TransactionService } from './services/transaction.service';
import { HotelService } from './services/hotel.service';
import { AuthGuardService } from './services/auth-guard.service';
import { Ng4LoadingSpinnerModule } from 'ng4-loading-spinner';
import { JwtModule } from '@auth0/angular-jwt';
import { 
  AuthGuardService as AuthGuard 
} from './services/auth-guard.service';

const appRoutes:Routes=[
  {
    path:'',
    component:IndexComponent
  },
  {
    path:'register',
    component:SignUpComponent},
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'dashboard',
    component:DashboardComponent,
    canActivate: [AuthGuard] 
  },
  {
    path:'profile',
    component:ProfileComponent,
    canActivate: [AuthGuard] 
  },
  {
    path:'flight-selection',
    component:FlightSelectionComponent
  },
  {
    path:'flight-confirmation',
    component:FlightConfirmationComponent
  },
  
    {
      path:'seat-selection',
    component:SeatSelectionComponent
  },
  {
    path:'travellers',
    component:TravellersComponent
  },
  {
    path:'traveller-confirmation',
    component:TravellerConfirmationComponent
  },
  {
    path:'flight-extra',
    component:FlightExtrasComponent
  },
  {
    path:'add-flight',
    component:AddFlightComponent,
    canActivate: [AuthGuard] 
  },
  {
    path:'add-car',
    component:AddCarComponent,
    canActivate: [AuthGuard] 
  },
  {
    path:'add-hotel',
    component:AddHotelComponent,
    canActivate: [AuthGuard] 
  },
  {
    path:'payment',
    component:FlightPaymentComponent
  },
  {
    path:'car-selection',
    component:CarSelectionComponent
  },
  {
    path:'payment-confirmation',
    component:PaymentConfirmationComponent
  },
  {
    path:'hotel-selection',
    component:HotelSelectionComponent
  },
  {
    path:'car-review',
    component:CarReviewComponent
  },
  {
    path:'hotel-review',
    component:HotelReviewComponent
  },
  {
    path:'driver-details',
    component:DriverDetailsComponent
  },
  {
    path:'hotel-travellers',
    component:HotelTravellersComponent
  },
  {
    path:'car-payment',
    component:CarPaymentComponent
  },
  {
    path:'hotel-confirmation',
    component:HotelConfirmationComponent
  },
  { path: '**', redirectTo: '' }
]
@NgModule({
  declarations: [
    AppComponent,
    AddCarComponent,
    AddFlightComponent,
    AddHotelComponent,
    BranchListComponent,
    CarExtraListComponent,
    CarPaymentComponent,
    CarReviewComponent,
    CarSelectionComponent,
    DashboardComponent,
    DriverDetailsComponent,
    FareListComponent,
    FlightConfirmationComponent,
    FlightExtraListComponent,
    FlightExtrasComponent,
    FlightListComponent,
    FlightSelectionComponent,
    IndexComponent,
    HotelConfirmationComponent,
    HotelReviewComponent,
    HotelSelectionComponent,
    HotelTravellersComponent,
    LoginComponent,
    NavBarComponent,
    FlightPaymentComponent,
    PaymentConfirmationComponent,
    ProfileComponent,
    RoomListComponent,
    SeatConfirmationComponent,
    SeatListComponent,
    SeatSelectionComponent,
    SignUpComponent,
    SignInComponent,
    TravellerConfirmationComponent,
    TravellersComponent,
    CarWaiverListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: () => {
          return localStorage.getItem('encode_token');
        }
      }
    }),
    Ng4LoadingSpinnerModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    FlashMessagesModule.forRoot(),
  ],
  providers: [UserService,AircraftService,CarService,TransactionService,HotelService,AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
