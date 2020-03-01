package com.ssm.movie.service;

import com.ssm.movie.bean.User;

import java.util.List;


public interface IUserRegisterService {

    /**
     * 保存用户
     * @return
     */
    void saveUser(User user);

    List<User> findByCode(String code);

    void updateEmailStatus(int id);

}
