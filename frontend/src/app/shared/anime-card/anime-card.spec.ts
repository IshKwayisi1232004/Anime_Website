import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimeCard } from './anime-card';

describe('AnimeCard', () => {
  let component: AnimeCard;
  let fixture: ComponentFixture<AnimeCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnimeCard],
    }).compileComponents();

    fixture = TestBed.createComponent(AnimeCard);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
