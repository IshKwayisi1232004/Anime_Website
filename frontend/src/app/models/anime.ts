export interface Anime {
  id: number;
  malId: number;
  title: string;
  synopsis: string | null;
  imageUrl: string | null;
  type: string | null;
  status: string | null;
  episodes: number | null;
  score: number | null;
  season: string | null;
  year: number | null;
}