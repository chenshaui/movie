package com.ssm.movie.service.impl;

import com.ssm.movie.bean.MovieMessage;
import com.ssm.movie.dao.IMovieMessageDao;
import com.ssm.movie.service.IMovieSingleService;
import com.ssm.movie.util.JedisUtil;
import com.ssm.movie.util.SerializableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieSingleServiceImpl implements IMovieSingleService {

    @Autowired
    private IMovieMessageDao movieMessageDao;

    @Override
    public List<MovieMessage> findBySrc(String src) throws Exception {

            ArrayList<MovieMessage> list = new ArrayList<>();
            Jedis jedis = JedisUtil.getJedis();
            byte[] message = jedis.get(src.getBytes());
            System.out.println(message);
            if (message == null) {
                List<MovieMessage> movieMessages = movieMessageDao.findBySrc(src);
                byte[] serializable = SerializableUtil.serializable(movieMessages.get(0));
                jedis.set(src.getBytes(), serializable);
                return movieMessages;
            }
            MovieMessage movieMessage = (MovieMessage) SerializableUtil.unUerializable(message);
            list.add(movieMessage);
            return list;


    }
}
