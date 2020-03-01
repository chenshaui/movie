package com.ssm.movie.web;

import com.ssm.movie.bean.ResultInfo;
import com.ssm.movie.bean.User;
import com.ssm.movie.service.IUserLoginSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    /**
     * 登录，获取邮箱号及密码
     * @param email
     * @param password
     */
    @Autowired
    private IUserLoginSercice userLoginSercice;
    @Autowired
    private ResultInfo resultInfo;

    @RequestMapping("/submitForm")
    public @ResponseBody ResultInfo loginForm(String email, String password) {

        try {
            List<User> users = userLoginSercice.findByEmail(email);
            if (users.size() == 1) {
                if (users.get(0).getEmail().equals(email) && users.get(0).getPassword().equals(password) && users.get(0).getEmailStatus().equals("Y")) {
                    resultInfo.setFlag(true);
                    return resultInfo;
                } else {
                    if (users.get(0).getEmailStatus().equals("N")) {
                        resultInfo.setFlag(false);
                        resultInfo.setErrorMsg("用户尚未激活！");
                        return resultInfo;
                    }
                    if (users.get(0).getEmail() != email && users.get(0).getPassword() != password) {
                        resultInfo.setFlag(false);
                        resultInfo.setErrorMsg("账号密码错误！");
                        return resultInfo;
                    }

                    resultInfo.setFlag(false);
                    resultInfo.setErrorMsg("数据缺失请联系管理员！");
                    return resultInfo;
                }
            } else {
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("用户不存在请注册！");
                return resultInfo;
            }
        } catch (Exception e) {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("服务器异常请稍后重试！");
            return resultInfo;
        }


    }
}
