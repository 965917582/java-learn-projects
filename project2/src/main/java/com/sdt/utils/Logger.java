package com.sdt.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 记录日志的工具类，提供了公共的代码
 */
public class Logger {
    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知Logger中的beforePrintLog方法开始记录日志");
    }
    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger中的afterReturningPrintLog方法开始记录日志");
    }
    /**
     * 异常通知
     */
    public void bafterThrowingPrintLog(){
        System.out.println("异常通知Logger中的bafterThrowingPrintLog方法开始记录日志");
    }
    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知Logger中的afterPrintLog方法开始记录日志");
    }
    /**
     * 环绕通知
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();

            System.out.println("Logger中的aroundPrintLog方法开始记录日志");
            pjp.proceed(args);
            System.out.println("Logger中的aroundPrintLog方法开始记录日志");

            return rtValue;
        }catch(Throwable t){
            System.out.println("Logger中的aroundPrintLog方法开始记录日志");
            throw new RuntimeException(t);
        }finally {
            System.out.println("Logger中的aroundPrintLog方法开始记录日志");
        }
    }
}
