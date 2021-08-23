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
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg login(User user){
        User u = userService.login(user);
        ResponseMsg msg = new ResponseMsg();

        if(u==null){
            msg.setCode("400");
            msg.setMsg("用户名密码错误");
        }else{
            msg.setCode("200");
            msg.setMsg("用户名密码正确");
        }
        msg.setData(u);
        return msg;
    }

    @RequestMapping(value = "/sign",method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg sign(User user){
        ResponseMsg msg = new ResponseMsg();

        //判断数据合法(非空)
        if(user.getAccount()==null || user.getPwd()==null ||user.getUname()==null || user.getRepwd()==null ){
            msg.setMsg("参数不能含空");
            msg.setCode("400");
            return msg;
        }
        //判断两次输入密码一致
        if(!user.getPwd().equals(user.getRepwd())){
            msg.setMsg("两次输入密码不一致");
            msg.setCode("400");
            return msg;
        }

        //添加用户
        userService.add(user);

        msg.setCode("200");
        msg.setMsg("注册成功");
        return msg;
    }



}
