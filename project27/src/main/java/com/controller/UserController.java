package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "user_login";
    }

    @RequestMapping("/home/home")
    public String home(){
        return "home";
    }


    @RequestMapping("/home/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/login/userLogin.do")
    @ResponseBody
    public String login(User user, HttpServletRequest req, Model model){
        //检验用户名密码
        User u = userService.login(user);

        if(u==null){
            return "userpass error";
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("loginUser",u);
            return "success";
        }
    }

    @RequestMapping("/login/logout")
    public String logout(HttpServletRequest req){
        //把用户从session删除，以退出登录
        HttpSession session = req.getSession();
        session.removeAttribute("loginUser");
        return "user_login";
    }
}
