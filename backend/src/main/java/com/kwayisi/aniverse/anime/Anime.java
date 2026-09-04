package com.kwayisi.aniverse.anime;

import jakarta.persistence.*;

@Entity
@Table(name="anime")
public class Anime {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private Long malId;

    @Column(nullable=false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    private String imageUrl;

    private String type;

    private String status;

    private Double score; 

    private Integer episodes;

    private String season;

    private Integer year;

    public Anime(){

    }

    public Anime(String title, String synopsis, String imageUrl, String type, String status, Double score, Integer episodes, String season, Integer year) {
        this.title = title;
        this.synopsis = synopsis;
        this.imageUrl = imageUrl;
        this.type = type;
        this.status = status;
        this.score = score;
        this.episodes = episodes;
        this.season = season;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getType() {
        return type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public Double getScore() {
        return score;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public Long getMalId() {
        return malId;
    }

    public String getSeason() {
        return season;
    }

    public Integer getYear() {
        return year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    } 

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setScore(Double score) {
        this.score = score;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public void setMalId(Long malId) {
        this.malId = malId;
    }
}
