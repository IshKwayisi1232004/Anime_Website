package com.kwayisi.aniverse.anime;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kwayisi.aniverse.jikan.JikanCompany;

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

    private String titleEnglish;
    private String titleJapanese;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    private String imageUrl;

    private String type;

    private String status;

    private Double score; 

    private Integer episodes;

    private Integer rank;

    private Integer popularity;

    
    private Integer members;

    private Integer favorites;

    private String season;

    private String source;

    private Integer year;

    public Anime(){

    }

    public Anime(String title, String synopsis, String imageUrl, String type, String status, Double score, Integer episodes, Integer rank, Integer popularity, Integer members, Integer favorites, String season, String source, Integer year) {
        this.title = title;
        this.synopsis = synopsis;
        this.imageUrl = imageUrl;
        this.type = type;
        this.status = status;
        this.score = score;
        this.episodes = episodes;
        this.rank = rank;
        this.popularity = popularity;
        this.members = members;
        this.favorites = favorites;
        this.season = season;
        this.source = source;
        this.year = year;
    }

    @ManyToMany
    @JoinTable(
        name = "anime_genres",
        joinColumns = @JoinColumn(name = "anime_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

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

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public String getTitleJapanese() {
        return titleJapanese;
    }

    public Integer getRank() {
        return rank;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public Integer getMembers() {
        return members;
    }

    public Integer getFavorites() {
        return favorites;
    }

    public String getSource() {
        return source;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    } 

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }

    public void setTitleJapanese(String titleJapanese) {
        this.titleJapanese = titleJapanese;
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

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public void setFavorites(Integer favorites) {
        this.favorites = favorites;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setMalId(Long malId) {
        this.malId = malId;
    }
}
