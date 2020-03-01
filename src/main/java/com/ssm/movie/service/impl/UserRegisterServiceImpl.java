package com.ssm.movie.service.impl;

import com.ssm.movie.bean.ResultInfo;
import com.ssm.movie.bean.User;
import com.ssm.movie.dao.IUserDao;
import com.ssm.movie.service.IUserRegisterService;
import com.ssm.movie.util.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegisterServiceImpl implements IUserRegisterService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private ResultInfo resultInfo;
    /**
     * 保存用户
     * @param user
     * @return
     */
    @Override
    public void saveUser(User user) {
        try {
            userDao.saveUser(user);
            String content="<a href='http://localhost:9884/movie_war/active.html?code="+user.getCode()+"'>点击激活【影评网】</a>";
            MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询激活码
     * @param code
     * @return
     */
    @Override
    public List<User> findByCode(String code) {
        System.out.println("findByCode");
        return userDao.findByCode(code);
    }

    /**
     * 由id查询学生信息
     * @param id
     */
    @Override
    public void updateEmailStatus(int id) {
        System.out.println("updateEmailStatus");
        userDao.updateEmailStatus(id);
    }


}
