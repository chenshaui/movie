package com.ssm.movie.service;

import com.ssm.movie.bean.User;

import java.util.List;

public interface IUserLoginSercice {


    /**
     * 登录
     * @param email
     * @return
     */
    List<User> findByEmail(String email);



}
