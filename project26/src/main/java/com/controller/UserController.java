package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login/userLogin.do")
    @ResponseBody
    public String login(String account, String passwd, HttpServletRequest req,Model model){
        //检验用户名密码
        User user = userService.login(new User(account, passwd));

        if(user==null){
            return "userpass error";
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("loginUser",user);
            return "success";
        }
    }
}
