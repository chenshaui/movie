package com.ssm.movie.service;

import com.ssm.movie.bean.User;

import java.util.List;

/**
 * 注册相关逻辑
 */
public interface IUserRegisterService {

    /**
     * 保存用户
     * @return
     */
    void saveUser(User user);

    /**
     * 由激活码查询用户
     * @param code
     * @return
     */
    List<User> findByCode(String code);

    /**
     * 查询用户激活状态
     * @param id
     */
    void updateEmailStatus(int id);

}
