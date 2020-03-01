package com.ssm.movie.service.impl;

import com.ssm.movie.bean.User;
import com.ssm.movie.dao.IUserDao;
import com.ssm.movie.service.IUserLoginSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserLoginServiceImpl implements IUserLoginSercice {
    @Autowired
    private IUserDao userDao;
    /**
     * 登录
     * @param email
     * @return
     */
    @Override
    public List<User> findByEmail (String email) {
        List<User> users = userDao.findByEmail(email);
        System.out.println(users);
        return users;
    }
}
