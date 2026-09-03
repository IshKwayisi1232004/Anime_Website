package com.kwayisi.aniverse.anime;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnimeRepository extends JpaRepository<Anime, Long> {
    
    Optional<Anime> findByMalId(Long malId);
}
