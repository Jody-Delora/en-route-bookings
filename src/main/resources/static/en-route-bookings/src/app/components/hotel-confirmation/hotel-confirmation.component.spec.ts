import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelConfirmationComponent } from './hotel-confirmation.component';

describe('HotelConfirmationComponent', () => {
  let component: HotelConfirmationComponent;
  let fixture: ComponentFixture<HotelConfirmationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HotelConfirmationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelConfirmationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
