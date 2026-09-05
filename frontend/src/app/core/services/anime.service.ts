import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Anime } from '../../models/anime';

@Injectable({
  providedIn: 'root',
})
export class AnimeService {
  private http = inject(HttpClient);

  private apiUrl = 'http://localhost:8080/api/anime';

  getAllAnime(): Observable<Anime[]> {
    return this.http.get<Anime[]>(this.apiUrl);
  }

  getAnimeById(id: number): Observable<Anime> {
    return this.http.get<Anime>(`${this.apiUrl}/${id}`);
  }
}
