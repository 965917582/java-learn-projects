package com.project46.service;

public class TestServiceImpl implements TestService{
    @Override
    public Double test(Double a,Integer b) {
        //System.out.println("a:"+a+",b:+b");
        return a+b;
    }
}
