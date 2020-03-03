package com.ssm.movie.dao;

import com.ssm.movie.bean.MovieMessage;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieMessageDao {
    /**
     * 查询电影信息
     * @param src
     * @return
     */
    @Select("select * from movieMessage where src = #{src}")
    List<MovieMessage> findBySrc(String src);
}
