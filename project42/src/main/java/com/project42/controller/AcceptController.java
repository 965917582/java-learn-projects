package com.project42.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接收项目B发送的请求
 */
@RestController
public class AcceptController {
    @GetMapping("accept")
    public String accept(){
        System.out.println("进入A1 accept");

        return "accept a1 success";
    }

}
