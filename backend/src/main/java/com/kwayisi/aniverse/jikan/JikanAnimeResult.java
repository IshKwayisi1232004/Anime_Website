package com.kwayisi.aniverse.jikan;

public class JikanAnimeResult {

    private Long mal_id;
    private String title;
    private String synopsis;
    private String status;
    private Integer episodes;
    private Double score;
    private String type;
    private String season;
    private Integer year;
    private JikanImages images;

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
}