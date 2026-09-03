package com.kwayisi.aniverse.anime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kwayisi.aniverse.jikan.JikanAnimeResult;
import com.kwayisi.aniverse.jikan.JikanService;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<Anime> getAnimeById(@PathVariable Long id) {
        return animeService.getAnimeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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

    // Additional endpoint to fetch anime details from Jikan API
    @GetMapping("/jikan/{malId}")
    public JikanAnimeResult getAnimeFromJikan(@PathVariable Long malId) {
        return jikanService.getAnime(malId);
    }

    // Endpoint to import anime from Jikan API and save to PostgreSQL
    @PostMapping("import/{malId}")
    public Anime importAnime(@PathVariable Long malId) {
        return animeService.importAnime(malId);
    }
}
