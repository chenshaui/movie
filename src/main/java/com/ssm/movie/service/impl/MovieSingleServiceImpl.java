package com.ssm.movie.service.impl;

import com.ssm.movie.bean.MovieMessage;
import com.ssm.movie.dao.IMovieMessageDao;
import com.ssm.movie.service.IMovieSingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieSingleServiceImpl implements IMovieSingleService {

    @Autowired
    private IMovieMessageDao movieMessageDao;

    @Override
    public List<MovieMessage> findBySrc(String src) {
        return movieMessageDao.findBySrc(src);

    }
}
