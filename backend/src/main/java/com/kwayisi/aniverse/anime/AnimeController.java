package com.kwayisi.aniverse.anime;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kwayisi.aniverse.jikan.JikanService;

@RestController
@RequestMapping("/api/anime")
@CrossOrigin(origins = "http://localhost:4200")
public class AnimeController {

    private final AnimeService animeService;
    private final JikanService jikanService;
    
    public AnimeController(AnimeService animeService, JikanService jikanService) {
        this.animeService = animeService;
        this.jikanService = jikanService;
    }

    @GetMapping
    public List<Anime> getAllAnime() {
        return animeService.getAllAnime();
    }

    @PostMapping
    public ResponseEntity<Anime> createAnime(@RequestBody Anime anime) {
        return ResponseEntity.ok(anime);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnime(@PathVariable Long id) {
        animeService.deleteAnime(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> getAnimeById(@PathVariable Long id) {
        return animeService.getAnimeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/import/{malId}")
    public Anime importAnime(@PathVariable Long malId) {
        return animeService.importAnime(malId);
    }
}