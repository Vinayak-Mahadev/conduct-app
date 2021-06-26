import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateConductComponent } from './create-conduct.component';

describe('CreateConductComponent', () => {
  let component: CreateConductComponent;
  let fixture: ComponentFixture<CreateConductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateConductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateConductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
