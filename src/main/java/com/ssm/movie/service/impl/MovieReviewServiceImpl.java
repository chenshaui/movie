package com.ssm.movie.service.impl;

import com.ssm.movie.bean.MovieReview;
import com.ssm.movie.dao.IMovieReviewDao;
import com.ssm.movie.service.IMovieReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieReviewServiceImpl implements IMovieReviewService {

    @Autowired
    private IMovieReviewDao movieReviewDao;

    @Override
    public void saveMovieReview(MovieReview movieReview) {
        movieReviewDao.saveMovieReview(movieReview);
    }

    @Override
    public List<MovieReview> selectMessage() {
        return movieReviewDao.selectAll();
    }
}
