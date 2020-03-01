package com.ssm.movie.web;

import com.ssm.movie.bean.ResultInfo;
import com.ssm.movie.bean.User;
import com.ssm.movie.service.IUserRegisterService;
import com.ssm.movie.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private ResultInfo resultInfo;

    @Autowired
    private IUserRegisterService userRegisterService;

    @Autowired
    private User user;

    @RequestMapping("/active")
    public @ResponseBody ResultInfo activeEmail(String code) {
        System.out.println(code);
        try {
            List<User> userByCode = userRegisterService.findByCode(code);
            System.out.println(userByCode.size());
            userRegisterService.updateEmailStatus(userByCode.get(0).getId());
            System.out.println(1);
            resultInfo.setFlag(true);
            return resultInfo;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(2);
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("激活失败！");
            return resultInfo;
        }
    }

    @RequestMapping("/userRegister")
    public @ResponseBody ResultInfo login(String name, String email, String password) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(password);
        try {
            user.setRegisterTime(new Date());
            user.setEmailStatus("N");
            user.setCode(UuidUtil.getUuid());
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            /*user.setId(1);*/
            System.out.println(1);
            userRegisterService.saveUser(user);
            System.out.println(2);
            resultInfo.setFlag(true);
            return resultInfo;
        } catch (Exception e) {
            e.getMessage();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败，请刷新后重试！");
            return resultInfo;
        }
    }



}
