import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Anime } from '../../models/anime';
import { AnimeCardComponent } from '../../shared/anime-card/anime-card';


@Component({
  selector: 'app-browse',
  standalone: true,
  imports: [CommonModule, FormsModule, AnimeCardComponent],
  templateUrl: './browse.html',
  styleUrl: './browse.scss',
})
export class Browse {
  
  searchQuery: string = '';

  selectedGenre: string = 'All';
  selectedSeason: string = 'All';
  selectedStatus: string = 'All';

  animes: Anime[] = [
      {
          id: 1,
          title: 'Frieren: Beyond Journey\'s End',
          image: 'assets/images/frieren.jpg',
          score: 9.3,
          episodes: 28,
          genres: ['Adventure', 'Fantasy']
      },
      {
          id: 2,
          title: 'Dandadan',
          image: 'assets/images/dandadan.jpg',
          score: 8.8,
          episodes: 12,
          genres: ['Comedy', 'Supernatural']
      },
      {
          id: 3,
          title: 'You and I Are Polar Opposites',
          image: 'assets/images/polar_opposites.jpg',
          score: 9.3,
          episodes: 13,
          genres: ['Romance', 'Comedy']
      },
      {
        id: 4,
        title: 'Kaiju No. 8',
        image: 'assets/images/kaiju8.jpg',
        score: 8.7,
        episodes: 12,
        genres: ['Action', 'Sci-Fi']
      },
      {
        id: 5,
        title: 'Ghost In The Shell',
        image: 'assets/images/ghostintheshell.jpg',
        score: 9.1,
        episodes: 1,
        genres: ['Action', 'Sci-Fi']
      },
      {
        id: 6,
        title: 'Spy x Family',
        image: 'assets/images/spyfamily.jpg',
        score: 9.9,
        episodes: 37,
        genres: ['Comedy', 'Action']
      },
      {
        id: 7,
        title: 'Smoking Behind the Supermarket with You',
        image: 'assets/images/smoking_behind_supermarket.jpg',
        score: 9.6,
        episodes: 12,
        genres: ['Romance', 'Slice of Life']
      }
    ];

    get filteredAnimes(): Anime[] {
      return this.animes.filter(anime => {

        const matchesSearch = 
          anime.title.toLowerCase().includes(this.searchQuery.toLowerCase());

        const matchesGenre = 
          this.selectedGenre === 'All' ||
          anime.genres.includes(this.selectedGenre);

          return matchesSearch && matchesGenre;
        
        })

    }
}
