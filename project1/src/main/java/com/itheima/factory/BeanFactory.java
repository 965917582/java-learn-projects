package com.itheima.factory;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class BeanFactory {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }
    public final void  setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
    public IAccountService getAccountService(){
        return (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            //开启事务
                            txManager.beginTransaction();
                            //操作
                            rtValue = method.invoke(accountService, args);
                            //提交事务
                            txManager.commit();
                            //返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //回滚事务
                            txManager.rollback();
                            throw new RuntimeException();
                        } finally {
                            //释放连接
                            txManager.release();
                        }

                    }
                });
    }
}













