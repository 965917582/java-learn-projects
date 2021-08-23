package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

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
}
