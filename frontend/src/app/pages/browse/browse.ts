import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { Anime } from '../../models/anime';
import { AnimeCardComponent } from '../../shared/anime-card/anime-card';
import { Navbar } from '../../shared/navbar/navbar';
import { AnimeService } from '../../core/services/anime.service';

@Component({
  selector: 'app-browse',
  standalone: true,
  imports: [CommonModule, FormsModule, AnimeCardComponent, Navbar],
  templateUrl: './browse.html',
  styleUrl: './browse.scss',
})
export class Browse implements OnInit {

  private animeService = inject(AnimeService);

  // Search query
  searchQuery: string = '';

  // Current filters
  selectedSeason: string = 'All';
  selectedStatus: string = 'All';
  selectedSort: string = 'default';

  // Pagination
  currentPage: number = 1;
  itemsPerPage: number = 5;

  // Anime data
  animes: Anime[] = [];
  filteredAnimesData: Anime[] = [];

  ngOnInit(): void {
    this.loadAnime();
  }

  private loadAnime(): void {
    this.animeService.getAllAnime().subscribe({
      next: (anime) => {
        this.animes = anime;
        this.filteredAnimesData = [...anime];
      },
      error: (error) => {
        console.error('Failed to load anime:', error);
      }
    });
  }

  applyFilters(): void {
    const query = this.searchQuery.trim().toLowerCase();

    this.filteredAnimesData = this.animes.filter(anime => {

      const matchesSearch =
        anime.title.toLowerCase().includes(query);

      const matchesSeason =
        this.selectedSeason === 'All' ||
        anime.season?.toLowerCase() === this.selectedSeason.toLowerCase();

      const matchesStatus =
        this.selectedStatus === 'All' ||
        anime.status?.toLowerCase() === this.selectedStatus.toLowerCase();

      return matchesSearch && matchesSeason && matchesStatus;
    });

    this.sortAnime();

    this.currentPage = 1;
  }

  clearFilters(): void {
    this.searchQuery = '';
    this.selectedSeason = 'All';
    this.selectedStatus = 'All';
    this.selectedSort = 'default';

    this.filteredAnimesData = [...this.animes];

    this.currentPage = 1;
  }

  sortAnime(): void {

    switch (this.selectedSort) {

      case 'score-desc':
        this.filteredAnimesData.sort(
          (a, b) => (b.score ?? 0) - (a.score ?? 0)
        );
        break;

      case 'score-asc':
        this.filteredAnimesData.sort(
          (a, b) => (a.score ?? 0) - (b.score ?? 0)
        );
        break;

      case 'title-asc':
        this.filteredAnimesData.sort(
          (a, b) => a.title.localeCompare(b.title)
        );
        break;

      case 'title-desc':
        this.filteredAnimesData.sort(
          (a, b) => b.title.localeCompare(a.title)
        );
        break;

      case 'episodes-desc':
        this.filteredAnimesData.sort(
          (a, b) => (b.episodes ?? 0) - (a.episodes ?? 0)
        );
        break;

      case 'episodes-asc':
        this.filteredAnimesData.sort(
          (a, b) => (a.episodes ?? 0) - (b.episodes ?? 0)
        );
        break;

      case 'default':
      default:
        break;
    }
  }

  get paginatedAnimes(): Anime[] {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;

    return this.filteredAnimesData.slice(startIndex, endIndex);
  }

  get totalPages(): number {
    return Math.ceil(
      this.filteredAnimesData.length / this.itemsPerPage
    );
  }

  nextPage(): void {
    if (this.currentPage < this.totalPages) {
      this.currentPage++;
    }
  }

  previousPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
    }
  }

  goToPage(page: number): void {
    if (page >= 1 && page <= this.totalPages) {
      this.currentPage = page;
    }
  }
}