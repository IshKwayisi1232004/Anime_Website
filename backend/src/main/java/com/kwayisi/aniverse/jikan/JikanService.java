package com.kwayisi.aniverse.jikan;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class JikanService {

    private final RestClient restClient;

    public JikanService() {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.jikan.moe/v4")
                .build();
    }

    public JikanAnimeResult getAnime(Long malId) {

        JikanAnimeResponse response = restClient.get()
                .uri("/anime/{id}", malId)
                .retrieve()
                .body(JikanAnimeResponse.class);

        return response.getData();
    }
}
