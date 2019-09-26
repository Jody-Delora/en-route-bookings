import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarWaiverListComponent } from './car-waiver-list.component';

describe('CarWaiverListComponent', () => {
  let component: CarWaiverListComponent;
  let fixture: ComponentFixture<CarWaiverListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarWaiverListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarWaiverListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
