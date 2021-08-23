package com.project39.controller;


import com.project39.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.UnknownServiceException;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user")String user){
        System.out.println(this);

        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }

    @RequestMapping("/hi")
    public void hi(){
        System.out.println(this);
    }

}
