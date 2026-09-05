package com.kwayisi.aniverse.anime;

import com.kwayisi.aniverse.jikan.JikanAnimeResult;
import com.kwayisi.aniverse.jikan.JikanService;
import com.kwayisi.aniverse.jikan.JikanGenre;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AnimeService {
    private final AnimeRepository animeRepository;
    private final JikanService jikanService;
    private final GenreRepository genreRepository;

    public AnimeService(AnimeRepository animeRepository, JikanService jikanService, GenreRepository genreRepository) {
        this.animeRepository = animeRepository;
        this.jikanService = jikanService;
        this.genreRepository = genreRepository;
    }

    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

    public Optional<Anime> getAnimeById(Long id) {
        return animeRepository.findById(id);
    }

    public Anime createAnime(Anime anime) {
        return animeRepository.save(anime);
    }

    public void deleteAnime(Long id) {
        animeRepository.deleteById(id);
    }

    public Anime importAnime(Long malId){
        
        // Check if we already have this anime in our database
        Optional<Anime> existingAnime = animeRepository.findByMalId(malId);

        if(existingAnime.isPresent()){
            return existingAnime.get();
        }

        // Get anime from Jikan API 
        JikanAnimeResult jikanAnime = jikanService.getAnime(malId);

        // Convert Jikan data into our Anime entity
        Anime anime = new Anime();

        anime.setMalId(jikanAnime.getMal_id());
        anime.setTitle(jikanAnime.getTitle());
        anime.setSynopsis(jikanAnime.getSynopsis());
        
        anime.setStatus(jikanAnime.getStatus());
        anime.setEpisodes(jikanAnime.getEpisodes());
        anime.setScore(jikanAnime.getScore());
        anime.setYear(jikanAnime.getYear());
        
        anime.setType(jikanAnime.getType());
        anime.setSeason(jikanAnime.getSeason());

        anime.setTitleEnglish(jikanAnime.getTitleEnglish());
        anime.setTitleJapanese(jikanAnime.getTitleJapanese());
        anime.setSource(jikanAnime.getSource());

        anime.setRank(jikanAnime.getRank());
        anime.setPopularity(jikanAnime.getPopularity());
        anime.setMembers(jikanAnime.getMembers());
        anime.setFavorites(jikanAnime.getFavorites());
    
        
        if(jikanAnime.getGenres() != null){
            Set<Genre> genres = jikanAnime.getGenres()
                .stream()
                .map(jikanGenre -> 
                    genreRepository.findByName(jikanGenre.getName())
                        .orElseGet(() -> 
                            genreRepository.save(
                                new Genre(jikanGenre.getName())
                            )
                        )
                )
                .collect(Collectors.toSet());

            anime.setGenres(genres);
        }

        if(jikanAnime.getImages() != null && 
            jikanAnime.getImages().getJpg() != null){

            anime.setImageUrl(
                jikanAnime.getImages()
                .getJpg()
                .getLarge_image_url()
            );
    }
        
        // Save to PostgreSQL database
        return animeRepository.save(anime);
    }
}
