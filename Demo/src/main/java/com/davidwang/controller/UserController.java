package com.davidwang.controller;

import com.davidwang.model.User;
import com.davidwang.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
   
    private UserService userService;

    public UserService getUserService() {
		return userService;
	}

    @Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/showuser")
    public String toIndex(HttpServletRequest request,Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "showUser";
    }

}
