package com.kwayisi.aniverse.anime;

import jakarta.persistence.*;

@Entity
@Table(name="anime")
public class Anime {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imageUrl;

    private String status;

    private String rating; 

    private Integer episodes;

    public Anime(){

    }

    public Anime(String title, String description, String imageUrl, String status, String rating, Integer episodes) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.status = status;
        this.rating = rating;
        this.episodes = episodes;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public String getRating() {
        return rating;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    } 

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }
}
