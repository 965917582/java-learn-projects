package com.sdt.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取到异常对象
        SysException se = null;
        if(e instanceof SysException){
            se = (SysException)e;
        }else{
            se = new SysException("系统正在维护");
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        return mv;
    }
}
