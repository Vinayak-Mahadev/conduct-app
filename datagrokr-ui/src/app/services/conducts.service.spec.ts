import { TestBed } from '@angular/core/testing';

import { ConductsService } from './conducts.service';

describe('ConductsService', () => {
  let service: ConductsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConductsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
