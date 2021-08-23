package com.controller;

import com.STdata;
import com.bean.UserPram;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

@Controller
public class LoginController {


    /**
     * 登录SSO
     */
    @RequestMapping("login")
    public ModelAndView login(String service, HttpServletRequest req, HttpServletResponse resp, UserPram user) throws IOException {
        service = URLEncoder.encode(service,"utf-8");
        if(user.getUsername()==null &&user.getPassword()==null){
            //判断当前会话用户是否有sso会话
            //若没有，响应登录页面
            ModelAndView mav = new ModelAndView();

            //String requestedSessionId = req.getRequestedSessionId();
            HttpSession session = req.getSession();
            Object logined = session.getAttribute("logined");
            if(logined==null){
                mav.addObject("service",service);
                mav.setViewName("login");
                return mav;
            }else{
                //若有session，说明当前用户已经登录sso
                //给用户一个票
                String st = req.getSession().getId()+ new Date().getTime();
                STdata.stdata.add(st);
                resp.sendRedirect(URLDecoder.decode(service)+"?ticket="+st);
            }
        }else{
            //验证用户名密码
            String username="zs";
            String password="123";
            //若验证通过，创建sso的session，给客户端sessionid的cookie
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                HttpSession session = req.getSession();
                session.setAttribute("logined",true);
                //生成一个st----保证是此用户且唯一
                String st = session.getId()+ new Date().getTime();
                //存储st
                STdata.stdata.add(st);
                resp.sendRedirect(URLDecoder.decode(service)+"?ticket="+st);
            }
        }

        return null;
    }


    @RequestMapping("serviceValidate")
    @ResponseBody
    public String serviceValidate(String service,String ticket){
        boolean contain = STdata.stdata.contains(ticket);
        if(contain){
            return "200";
        }else{
            return "400";
        }

    }


}
