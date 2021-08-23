package com.itheima.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

 /**
 * 事务管理相关的工具类
 * 开启事务，提交事务，回滚事务，释放连接
 */
@Aspect//切面类
public class TransactionManager {
    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")//切入点
    private void pt1(){}
    private ConnectionUtils connectionUtils;
    public void setConnectionUtils(ConnectionUtils connectionUtils){
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    //@Before("pt1()")
    public void beginTransaction(){
        try{
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    //@AfterReturning("pt1()")
    public void commit(){
        try{
            connectionUtils.getThreadConnection().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    //@AfterThrowing("pt1()")
    public void rollback(){
        try{
            connectionUtils.getThreadConnection().rollback();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    //@After("pt1()")
    public void release(){
        try{
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 环绕通知
     * @param pjp
     * @return
     */
    @Around("pt1()")
    public Object aroundTx(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();

            this.beginTransaction();
            pjp.proceed(args);
            this.commit();

            return rtValue;
        }catch(Throwable t){
            this.rollback();
            throw new RuntimeException(t);
        }finally {
            this.rollback();
        }
    }
}



























