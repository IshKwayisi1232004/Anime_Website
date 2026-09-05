import { TestBed } from '@angular/core/testing';

import { Anime } from './anime';

describe('Anime', () => {
  let service: Anime;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Anime);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
