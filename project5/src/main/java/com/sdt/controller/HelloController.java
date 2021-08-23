package com.sdt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

    @RequestMapping(path="/hello")
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }

    @RequestMapping(path="/testRequestHeader")
    public String testRequestHeader(@RequestHeader("User-Agent") String head){
        System.out.println("TestRequestHeader");
        System.out.println(head);
        return "success";
    }

    @RequestMapping(path="/testPathVaribale/{id}")
    public String testPathVaribale(@PathVariable(name="id") String id){
        System.out.println("testPathVaribale");
        System.out.println(id);
        return "success";
    }
}
