package com.interceptor;

import com.pojo.User;
import com.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ActionInterceptor implements HandlerInterceptor {
    @Autowired
    ActionService actionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        //看动作数据库有没有这个动作，如果没有，直接放行
        List<String> allName = actionService.findAllName();
        boolean flag=false;
        for (String name : allName) {
            if(requestURI!=null && requestURI.contains(name)){
                flag=true;
                break;
            }
        }
        if(!flag){
            return true;
        }

        //看是不是权限类型的动作，如果不是，直接放行
        List<String> noPriviActions = actionService.findAllNameByType(1);
        for (String noPriviAction : noPriviActions) {
            if(requestURI!=null && requestURI.contains(noPriviAction)){
                return true;
            }
        }

        //看是不是当前用户角色的动作
        List<String> actionNames = actionService.findAllNameByRole(request);
        //没登录，直接拦截
        if(actionNames!=null) {
            for (String actionName : actionNames) {
                if (requestURI != null && requestURI.contains(actionName)) {
                    return true;
                }
            }
        }

        return false;
    }
}
