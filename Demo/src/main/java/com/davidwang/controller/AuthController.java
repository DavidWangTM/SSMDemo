package com.davidwang.controller;

import com.davidwang.core.TokenManager;
import com.davidwang.model.User;
import com.davidwang.service.UserService;
import com.davidwang.utils.LoggerUtils;
import com.davidwang.utils.StringUtils;
import com.davidwang.utils.VerifyCodeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by DavidWang on 16/7/22.
 */

@Controller
@RequestMapping("/")
public class AuthController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }


    @RequestMapping("/login")
    public String login(User user,Model mode){
        return "../../login" ;
    }


    @RequestMapping("/loginAdmin")
    public String loginAdmin(String vcode,User user, Model model){
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword()) ;
        try {
            subject.login(token);
            if(!VerifyCodeUtils.verifyCode(vcode)){
                model.addAttribute("error","验证码错误") ;
                return "../../login" ;
            }else{
                return "admin" ;
            }

        }catch (Exception e){
            String name = user.getName();
            String password = user.getPassword();
            if (name == null && password == null){
                model.addAttribute("error","账号密码不能为空") ;
            }else{
                model.addAttribute("error","用户名或密码错误") ;
            }
            return "../../login" ;
        }
    }

    @RequestMapping("/exit")
    public String signout (HttpServletResponse response, Model model){
        try {
            SecurityUtils.getSubject().logout();
            model.addAttribute("error",SecurityUtils.getSubject().getSession()+"退出成功") ;
        }catch (Exception e){
            model.addAttribute("error","退出失败") ;
        }
        return "../../login";
    }

}
