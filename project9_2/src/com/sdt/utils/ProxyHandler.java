package com.sdt.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ProxyHandler implements InvocationHandler {
    Object obj;
    public ProxyHandler(Object obj){
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Connection connection = JDBCUtils.getConnection();
        connection.setAutoCommit(false);
        Object invoke=null;
        try{
            invoke = method.invoke(obj, args);
            connection.commit();
        }catch(Exception e){
            connection.rollback();
        }finally {
            JDBCUtils.close(null,null);
        }
        return invoke;
    }
}
