package com.filter;

import com.util.HttpClientUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        String requestURL = String.valueOf(req.getRequestURL());
        String encode = URLEncoder.encode(requestURL, "utf-8");


        //是否是带有ticket的请求
        String ticket = req.getParameter("ticket");
        if(ticket!=null){
            //去sso验证ticket
            String res = HttpClientUtils.doGet("http://localhost:8081/sso/serviceValidate?service=" + encode + "&ticket=" + ticket);
            if(res.contains("200")){
                //新建session，让客户端重定向(去掉ticket)
                HttpSession session = req.getSession();
                session.setAttribute("logined",true);
                //requestURL = requestURL.substring(0, requestURL.indexOf("ticket"));
                resp.sendRedirect(requestURL);
                return;
            }
        }else{
            //看是否已经登录(是否有session),如果没有滚去sso系统登录(让客户端重定向)
            //String requestedSessionId = req.getRequestedSessionId();
            HttpSession session = req.getSession();
            Object loggedin = session.getAttribute("logined");
            if(loggedin==null ){
                resp.sendRedirect("http://localhost:8081/sso/login?service="+encode);
                return;
            }else{
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
