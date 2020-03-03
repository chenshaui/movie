package com.ssm.movie.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class MovieReview implements Serializable {
    private long id;
    private String userCode;
    private String review;
    private String movieSrc;
    private String status;
    private Date reviewTime;
    private String userName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getMovieSrc() {
        return movieSrc;
    }

    public void setMovieSrc(String movieSrc) {
        this.movieSrc = movieSrc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "MovieReview{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", review='" + review + '\'' +
                ", movieSrc='" + movieSrc + '\'' +
                ", status='" + status + '\'' +
                ", reviewTime=" + reviewTime +
                ", userName='" + userName + '\'' +
                '}';
    }
}
