package com.ssm.movie.service;

import com.ssm.movie.bean.MovieMessage;

import java.util.List;

public interface IMovieSingleService {

    /**
     * 查询电影信息
     * @param src
     * @return
     */
    List<MovieMessage> findBySrc(String src);
}
