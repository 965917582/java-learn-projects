package com.sdt.controller;

import com.sdt.domain.ResponseMsg;
import com.sdt.domain.User;
import com.sdt.service.CartService;
import com.sdt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;

    /**
     * 登录
     * 若用户名密码错误，返回
     * 若用户名密码正确，给予登录(解决方案为客户端设置cookie:nowuser=用户id)，并将未登录时的客户端cookie购物车数据合并入此用户的服务端redis购物车数据
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public ResponseMsg login(User user,HttpServletRequest req, HttpServletResponse resp){
        User u = userService.login(user);
        ResponseMsg msg = new ResponseMsg();

        if(u==null){
            msg.setCode("400");
            msg.setMsg("用户名密码错误");
        }else{
            msg.setCode("200");
            msg.setMsg("用户名密码正确");
            //用户信息存入cookie
            Cookie cookie = new Cookie("nowuser",u.getUserId()+"");
            cookie.setPath("/");
            resp.addCookie(cookie);

            //将未登录的购物车数据合并入已登录的购物车数据
            cartService.mergeCart(req,u.getUserId(),resp);
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
        //判断数据合法(非空)
        if(user.getUserName()==null || user.getUserPsd()==null  ){
            msg.setMsg("参数不能含空");
            return msg;
        }
        //添加用户
        userService.add(user);
        msg.setCode("200");
        msg.setMsg("注册成功");

        return msg;
    }

    /**
     * 注销
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public ResponseMsg logout(User user, HttpServletRequest req,HttpServletResponse resp){
        //删除客户端的nowuser cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if("nowuser".equals(cookie.getName())){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                resp.addCookie(cookie);
                break;
            }
        }
        
        ResponseMsg msg = new ResponseMsg();
        msg.setCode("200");
        msg.setMsg("已注销");

        return msg;
    }
}
