package com.ssm.movie.service;

import com.ssm.movie.bean.MovieReview;

import java.util.List;

public interface IMovieReviewService {
    /**
     * 保存评论信息
     * @param movieReview
     */
    void saveMovieReview(MovieReview movieReview);

    /**
     * 查询最后二十条数据
     * @return
     */
    List<MovieReview> selectMessage();
}
