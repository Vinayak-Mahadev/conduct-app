import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateConductComponent } from './update-conduct.component';

describe('UpdateConductComponent', () => {
  let component: UpdateConductComponent;
  let fixture: ComponentFixture<UpdateConductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateConductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateConductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
