package com.sdt.controller;

import com.sdt.domain.ResponseMsg;
import com.sdt.domain.User;
import com.sdt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 检查登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg login(User user){
        User u = userService.login(user);
        ResponseMsg msg = new ResponseMsg();
        msg.setCode("200");
        if(u==null){
            msg.setMsg("用户名密码错误");
        }else{
            msg.setMsg("用户名密码正确");
        }
        msg.setData(u);
        return msg;
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/sign",method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg sign(User user){
        ResponseMsg msg = new ResponseMsg();
        msg.setCode("200");
        //判断数据合法(非空)
        if(user.getUserName()==null || user.getUserPsd()==null){
            msg.setMsg("参数不能含空");
            return msg;
        }
        //添加用户
        userService.add(user);
        msg.setMsg("注册成功");

        return msg;
    }
}
