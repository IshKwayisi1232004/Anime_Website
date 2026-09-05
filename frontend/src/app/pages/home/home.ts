import { Component, OnInit, inject } from '@angular/core';
import { Anime } from '../../models/anime';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AnimeCardComponent } from '../../shared/anime-card/anime-card';
import { Navbar } from '../../shared/navbar/navbar';
import { AnimeService } from '../../core/services/anime.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule, 
    RouterLink, 
    AnimeCardComponent, 
    Navbar
  ],
  templateUrl: './home.html',
  styleUrl: './home.scss'
})

export class HomeComponent implements OnInit {
  trendingAnimes: Anime[] = [];
  seasonalAnimes: Anime[] = [];
  recentlyAddedAnimes: Anime[] = [];

  private animeService = inject(AnimeService);

  animeList: Anime[] = [];

  ngOnInit(): void {
      this.loadAnime();
  }

  private loadAnime(): void {
    this.animeService.getAllAnime().subscribe({
      next: (anime) => {
        this.animeList = anime;

        this.seasonalAnimes = anime.filter(a => a.season === 'spring' || a.season === 'summer' || a.season === 'fall' || a.season === 'winter');
        this.trendingAnimes = anime;
        this.recentlyAddedAnimes = anime.slice(-5); // Get the last 5 items
      },
      error: (error) => {
        console.error('Failed to load anime:', error);
      }
    });
  }
}
