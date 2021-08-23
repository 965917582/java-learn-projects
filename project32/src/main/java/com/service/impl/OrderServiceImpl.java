package com.service.impl;

import com.dao.OrderDao;
import com.pojo.Torder;
import com.pojo.User;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Override
    public void add(HttpServletRequest req,Torder order) {
        HttpSession session = req.getSession();
        User nowuser = (User)session.getAttribute("nowuser");
        order.setUser_id(nowuser.getUser_id());
        orderDao.add(order);
    }
}
