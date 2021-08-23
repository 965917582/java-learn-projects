package com.filter;

import com.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        //请求静态资源、登录资源--->直接放行
        String requestURI = req.getRequestURI();
        if(requestURI.contains(".js") || requestURI.contains("login") || requestURI.contains("regist") || requestURI.contains("logout") || requestURI.contains("Back")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }


        HttpSession session = req.getSession();
        User nowuser = (User)session.getAttribute("nowuser");
        if(nowuser!=null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }else{
            req.getRequestDispatcher("/html/login.html").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
