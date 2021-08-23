package com.service;

import com.pojo.Torder;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {
    void add(HttpServletRequest req,Torder order);
}
