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
  
  // Search query
  searchQuery: string = '';

  // Current filters
  selectedGenre: string = 'All';
  selectedSeason: string = 'All';
  selectedStatus: string = 'All';
  selectedSort: string = 'default';

  // Mock Anime dataset
  animes: Anime[] = [];

    // Filtered anime dataset
    filteredAnimesData: Anime[] = [];

    ngOnInit(): void{
      this.loadMockData();

      // Initially display everything
      this.filteredAnimesData = [...this.animes];
    }

    private loadMockData(): void {
      this.animes = [
        {
            id: 1,
            title: 'Frieren: Beyond Journey\'s End',
            image: 'assets/images/frieren.jpg',
            score: 9.3,
            episodes: 28,
            genres: ['Adventure', 'Fantasy'],
            season: 'Spring',
            status: 'Finished'
        },
        {
            id: 2,
            title: 'Dandadan',
            image: 'assets/images/dandadan.jpg',
            score: 8.8,
            episodes: 12,
            genres: ['Comedy', 'Supernatural'],
            season: 'Winter',
            status: 'Finished'
        },
        {
            id: 3,
            title: 'You and I Are Polar Opposites',
            image: 'assets/images/polar_opposites.jpg',
            score: 9.3,
            episodes: 13,
            genres: ['Romance', 'Comedy'],
            season: 'Spring',
            status: 'Finished'
        },
        {
          id: 4,
          title: 'Kaiju No. 8',
          image: 'assets/images/kaiju8.jpg',
          score: 8.7,
          episodes: 12,
          genres: ['Action', 'Sci-Fi'],
          season: 'Fall',
          status: 'Finished'
        },
        {
          id: 5,
          title: 'Ghost In The Shell',
          image: 'assets/images/ghostintheshell.jpg',
          score: 9.1,
          episodes: 1,
          genres: ['Action', 'Sci-Fi'],
          season: 'Summer',
          status: 'Finished'
        },
        {
          id: 6,
          title: 'Spy x Family',
          image: 'assets/images/spyfamily.jpg',
          score: 9.9,
          episodes: 37,
          genres: ['Comedy', 'Action'],
          season: 'Fall',
          status: 'Finished'
        },
        {
          id: 7,
          title: 'Smoking Behind the Supermarket with You',
          image: 'assets/images/smoking_behind_supermarket.jpg',
          score: 9.6,
          episodes: 12,
          genres: ['Romance', 'Slice of Life'],
          season: 'Spring',
          status: 'Finished'
        }
      ]
    }

    applyFilters(): void {

      const query = this.searchQuery.trim().toLowerCase(); 

      this.filteredAnimesData = this.animes.filter(anime => {

        const matchesSearch =
          anime.title.toLowerCase().includes(query);

        const matchesSeason =
          this.selectedSeason === 'All' ||
          anime.season === this.selectedSeason;

        const matchesStatus =
          this.selectedStatus === 'All' ||
          anime.status === this.selectedStatus;

        return matchesSearch && matchesSeason && matchesStatus;
      });

      this.sortAnime();

    }

    clearFilters(): void {
      this.searchQuery = '';
      this.selectedSeason = 'All';
      this.selectedStatus = 'All';
      this.selectedSort = 'default';

      this.filteredAnimesData = [...this.animes];
  }

  sortAnime(): void {

    switch (this.selectedSort){
      case 'score-desc':
        this.filteredAnimesData.sort(
          (a, b) => b.score - a.score
        );

        break;

      case 'score-asc': 
        this.filteredAnimesData.sort(
          (a, b) => a.score - b.score
        );

        break;
      
      case 'title-asc':
        this.filteredAnimesData.sort(
          (a, b) => a.title.localeCompare(b.title)
        )

        break; 

      case 'title-desc':
        this.filteredAnimesData.sort(
          (a, b) => b.title.localeCompare(a.title)
        );

        break;

      case 'episodes-desc':
        this.filteredAnimesData.sort(
          (a, b) => b.episodes - a.episodes
        )

        break; 

      case 'episdoes-asc':
        this.filteredAnimesData.sort(
          (a, b) => a.episodes - b.episodes
        );

        break;

      case 'default':
        default:
          break;
    }
  }
}
