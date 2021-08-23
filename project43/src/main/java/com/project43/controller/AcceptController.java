package com.project43.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接收项目B发送的请求
 */
@RestController
public class AcceptController {
    @GetMapping("accept")
    public String accept(){
        System.out.println("进入A2 accept");

        return "accept a2 success";
    }

}
