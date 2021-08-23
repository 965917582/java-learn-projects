package com.sdt.controller;

import com.sdt.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class Test {

    @RequestMapping("/testException")
    public String testException() throws Exception{

        try {
            int a=1/0;
        } catch (Exception e) {
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("查询商品出现错误");

        }
        return "login";
    }
}
