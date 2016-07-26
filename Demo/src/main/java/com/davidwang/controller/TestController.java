package com.davidwang.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DavidWang on 16/7/22.
 */
@Controller
@RequestMapping("/test")
@RequiresRoles("admin")
@RequiresPermissions("test:*")
public class TestController {


    @RequestMapping(value="")
    public String testIndex(HttpServletRequest request, Model model){
        model.addAttribute("test", "test");
        return "index";
    }

}

