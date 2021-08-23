package com.sdt.mybatis.sqlsession.proxy;

import com.sdt.mybatis.cfg.Mapper;
import com.sdt.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler  {
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers,Connection conn){
        this.mappers = mappers;
        this.conn=conn;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法名
        String methodName = method.getName();
        //获取方法所在类名
        String className = method.getDeclaringClass().getName();
        //组合key
        String key = className+'.'+methodName;
        Mapper mapper = mappers.get(key);
        if(mapper==null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //调用工具类执行
        return new Executor().selectList(mapper,conn);
    }
}
