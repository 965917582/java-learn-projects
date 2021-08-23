package com.sdt.controller;

import com.sdt.anno.MyMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class MyController {

    @MyMapping("/login")
    public String login(){
        System.out.println("login方法");
        return "success";
    }

    @MyMapping("/test")
    public String test(){
        return "success";
    }
}
