package com.project45.controller;

import com.project45.handler.TestHandler;
import com.project45.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Proxy;
@Controller
public class HelloController {

    @GetMapping("hello")
    @ResponseBody
    public String hello(Double a,Integer b){
        TestService o = (TestService)Proxy.newProxyInstance(TestService.class.getClassLoader(),
                new Class[] { TestService.class },
                new TestHandler());
        String res = o.test(a,b);

        return res;
    }

}
