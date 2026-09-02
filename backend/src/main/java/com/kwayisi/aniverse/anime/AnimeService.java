package com.kwayisi.aniverse.anime;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {
    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
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
}
