package com.ssm.movie.dao;

import com.ssm.movie.bean.MovieReview;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieReviewDao {
    /**
     * 存储评论信息
     * @param movieReview
     */
    @Insert("insert into movieReview (userCode, review, movieSrc, status, reviewTime, userName) values (#{userCode}, #{review}, #{movieSrc}, #{status}, #{reviewTime}, #{userName})")
    void saveMovieReview(MovieReview movieReview);

    @Select("select movieReview.review, movieReview.reviewTime, movieReview.userName, movieReview.id from movieReview where status='Y' order by id desc limit 20")
    List<MovieReview> selectAll();

}
