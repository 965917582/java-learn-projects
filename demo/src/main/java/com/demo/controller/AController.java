package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AController {

    @GetMapping("/a")
    public void a(){
        System.out.println(this);
    }
}
