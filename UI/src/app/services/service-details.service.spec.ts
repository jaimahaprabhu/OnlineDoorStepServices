import { TestBed } from '@angular/core/testing';

import { ServiceDeatils } from './service-details.service';

describe('FetchServiceService', () => {
  let service: ServiceDeatils;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceDeatils);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
