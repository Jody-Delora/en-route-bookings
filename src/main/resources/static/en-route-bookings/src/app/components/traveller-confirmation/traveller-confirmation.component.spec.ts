import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TravellerConfirmationComponent } from './traveller-confirmation.component';

describe('TravellerConfirmationComponent', () => {
  let component: TravellerConfirmationComponent;
  let fixture: ComponentFixture<TravellerConfirmationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TravellerConfirmationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TravellerConfirmationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
