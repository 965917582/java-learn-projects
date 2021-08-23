package com.jty.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mlog")
public class MlogController {

    @RequestMapping("/toPage")
    public String toPage(){
        return "mlog";
    }

    public void getAllMlog(){

    }

}
