import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelTravellersComponent } from './hotel-travellers.component';

describe('HotelTravellersComponent', () => {
  let component: HotelTravellersComponent;
  let fixture: ComponentFixture<HotelTravellersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HotelTravellersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelTravellersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
