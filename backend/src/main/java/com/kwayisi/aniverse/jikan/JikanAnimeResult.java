package com.kwayisi.aniverse.jikan;

import java.util.List;

public class JikanAnimeResult {

    private Long mal_id;
    private String title;
    private String titleEnglish;
    private String titleJapanese;
    private String synopsis;
    private String status;
    
    private Integer episodes;
    private Integer rank;
    private Integer popularity;
    private Integer members;
    private Integer favorites;

    private List<JikanCompany> studios;
    private List<JikanCompany> producers;
    
    private Double score;
    private String type;
    private String season;
    private Integer year;
    private String source;
    private JikanImages images;

    private List<JikanGenre> genres;

    public Long getMal_id() {
        return mal_id;
    }

    public void setMal_id(Long mal_id) {
        this.mal_id = mal_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public JikanImages getImages() {
        return images;
    }

    public void setImages(JikanImages images) {
        this.images = images;
    }

    public String getType() {
        return type;
    }

    public void setType(String type){
        this.type = type;
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

    public List<JikanCompany> getStudios() {
        return studios;
    }

    public List<JikanCompany> getProducers() {
        return producers;
    }

    public String getSource() {
        return source;
    }

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }

    public void setTitleJapanese(String titleJapanese) {
        this.titleJapanese = titleJapanese;
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

    public void setStudios(List<JikanCompany> studios) {
        this.studios = studios;
    }

    public void setProducers(List<JikanCompany> producers) {
        this.producers = producers;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<JikanGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<JikanGenre> genres) {
        this.genres = genres;
    }
}