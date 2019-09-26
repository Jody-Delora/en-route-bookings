import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeatConfirmationComponent } from './seat-confirmation.component';

describe('SeatConfirmationComponent', () => {
  let component: SeatConfirmationComponent;
  let fixture: ComponentFixture<SeatConfirmationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeatConfirmationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeatConfirmationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
