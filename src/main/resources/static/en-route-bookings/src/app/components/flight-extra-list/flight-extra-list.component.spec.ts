import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightExtraListComponent } from './flight-extra-list.component';

describe('FlightExtraListComponent', () => {
  let component: FlightExtraListComponent;
  let fixture: ComponentFixture<FlightExtraListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlightExtraListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightExtraListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
