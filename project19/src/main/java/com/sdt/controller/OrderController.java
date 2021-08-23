package com.sdt.controller;

import com.sdt.domain.Order;
import com.sdt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 生成订单
     * 同时清除缓存
     * 转发至购物车页面，回显信息
     */
    @RequestMapping("/generateOrder")
    public String generateOrder(Integer[] checkComm, Model model){
        orderService.generateOrder(checkComm);
        model.addAttribute("msg","已生成订单");
        return "forward:/cart/cartPage";
    }

    @RequestMapping("/orderPage")
    public ModelAndView orderPage(){
        ModelAndView mav = new ModelAndView();
        List<Order> orders = orderService.findAll();
        mav.addObject("orders",orders);
        mav.setViewName("orderPage");
        return mav;
    }

    @RequestMapping("/cancelOrder")
    public String cancelOrder(Integer orderId){
        orderService.deleteOrder(orderId);
        return "forward:/order/orderPage";
    }

}
