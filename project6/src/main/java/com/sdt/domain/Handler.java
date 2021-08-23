package com.sdt.domain;

import java.lang.reflect.Method;

public class Handler {
    //调用对象
    private Object obj;
    //方法对象
    private Method method;
    //方法参数
    private Object[] args;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
