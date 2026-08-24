import { Component, Input } from '@angular/core';
import { Anime } from '../../models/anime';

@Component({
  selector: 'app-anime-card',
  imports: [],
  templateUrl: './anime-card.html',
  styleUrl: './anime-card.scss',
})
export class AnimeCardComponent {
  @Input({ required: true }) anime!: Anime;
}
