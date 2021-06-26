import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConductDetailsComponent } from './conduct-details.component';

describe('ConductDetailsComponent', () => {
  let component: ConductDetailsComponent;
  let fixture: ComponentFixture<ConductDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConductDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConductDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
