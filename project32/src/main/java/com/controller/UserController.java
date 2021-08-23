package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest req,String account, String pwd){
        User user = userService.login(account, pwd);
        if(user!=null){
            HttpSession session = req.getSession();
            session.setAttribute("nowuser",user);
            return "success";
        }else{
            return "fail";
        }
    }


    @RequestMapping("/regist")
    @ResponseBody
    public String regist(User user){
        userService.add(user);
        return "success";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest req){
        HttpSession session = req.getSession();
        session.removeAttribute("nowuser");
        return "success";
    }


}
