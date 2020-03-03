package com.ssm.movie.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class MovieMessage implements Serializable {
    private int id;
    private String movie;
    private String category;
    private String releaseDate;
    private String director;
    private String actors;
    private String ageRestriction;
    private String src;
    private String country;
    private String movieReview;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMovieReview() {
        return movieReview;
    }

    public void setMovieReview(String movieReview) {
        this.movieReview = movieReview;
    }

    @Override
    public String toString() {
        return "MovieMessage{" +
                "id=" + id +
                ", movie='" + movie + '\'' +
                ", category='" + category + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", ageRestriction='" + ageRestriction + '\'' +
                ", src='" + src + '\'' +
                ", country='" + country + '\'' +
                ", movieReview='" + movieReview + '\'' +
                '}';
    }
}
