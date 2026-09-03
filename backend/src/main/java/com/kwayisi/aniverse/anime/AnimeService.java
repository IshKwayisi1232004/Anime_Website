package com.kwayisi.aniverse.anime;

import com.kwayisi.aniverse.jikan.JikanAnimeResult;
import com.kwayisi.aniverse.jikan.JikanService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {
    private final AnimeRepository animeRepository;
    private final JikanService jikanService;

    public AnimeService(AnimeRepository animeRepository, JikanService jikanService) {
        this.animeRepository = animeRepository;
        this.jikanService = jikanService;
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
        anime.setDescription(jikanAnime.getSynopsis());
        anime.setStatus(jikanAnime.getStatus());
        anime.setEpisodes(jikanAnime.getEpisodes());
        anime.setRating(jikanAnime.getScore());

        // Save to PostgreSQL database
        return animeRepository.save(anime);
    }
}
