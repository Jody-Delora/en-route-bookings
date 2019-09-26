import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarExtraListComponent } from './car-extra-list.component';

describe('CarExtraListComponent', () => {
  let component: CarExtraListComponent;
  let fixture: ComponentFixture<CarExtraListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarExtraListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarExtraListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
