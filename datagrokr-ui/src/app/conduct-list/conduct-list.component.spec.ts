import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConductListComponent } from './conduct-list.component';

describe('ConductListComponent', () => {
  let component: ConductListComponent;
  let fixture: ComponentFixture<ConductListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConductListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConductListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
