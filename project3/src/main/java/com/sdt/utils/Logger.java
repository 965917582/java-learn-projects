package com.sdt.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 记录日志的工具类，提供了公共的代码
 */

@Component("logger")
@Aspect//表示当前类是一个切面类
public class Logger {
    @Pointcut("execution(* com.sdt.service.impl.*.*(..))")
    private void pt1(){}
    /**
     * 前置通知
     */
    //@Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知Logger中的beforePrintLog方法开始记录日志");
    }
    /**
     * 后置通知
     */
    //@AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger中的afterReturningPrintLog方法开始记录日志");
    }
    /**
     * 异常通知
     */
    //@AfterThrowing("pt1()")
    public void bafterThrowingPrintLog(){
        System.out.println("异常通知Logger中的bafterThrowingPrintLog方法开始记录日志");
    }
    /**
     * 最终通知
     */
    //@After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知Logger中的afterPrintLog方法开始记录日志");
    }
    /**
     * 环绕通知
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();

            System.out.println("前置Logger中的aroundPrintLog方法开始记录日志");
            pjp.proceed(args);
            System.out.println("后置Logger中的aroundPrintLog方法开始记录日志");

            return rtValue;
        }catch(Throwable t){
            System.out.println("异常Logger中的aroundPrintLog方法开始记录日志");
            throw new RuntimeException(t);
        }finally {
            System.out.println("最终Logger中的aroundPrintLog方法开始记录日志");
        }
    }
}
