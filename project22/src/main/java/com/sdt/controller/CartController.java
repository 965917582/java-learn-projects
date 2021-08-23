package com.sdt.controller;

import com.sdt.domain.CartItem;
import com.sdt.domain.ResponseMsg;
import com.sdt.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    /**
     * 添加至购物车
     */
    @RequestMapping(value = "/addTocart",method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg addTocart(CartItem cartItem ,HttpServletRequest req, HttpServletResponse resp){
        //判断是否登录(请求发来的cookie的nowuser是否为空)，若没登录，回写响应把购物车存在cookie。若已登录，存入redis
        if(cartItem.getUserId()==null ){
            cartService.addToCart(cartItem,req,resp);
        }else{
            cartService.addToCartForLogin(cartItem);
        }
        ResponseMsg msg = new ResponseMsg();
        msg.setCode("200");
        msg.setMsg("添加购物车成功");
        return msg;
    }

    /**
     * 获取当前用户/或未登录用户所有购物车数据
     * 若未登录，调getAll()
     * 若已登录，调getAllForLogin()
     */
    @RequestMapping(value = "/getAllCartList",method = RequestMethod.GET)
    @ResponseBody
    public ResponseMsg getAllCartList(HttpServletRequest req,Integer userId){
        List<CartItem> cartItems = null;
        if(userId==null){
            cartItems = cartService.getAll(req);
        }
        else{
            cartItems = cartService.getAllForLogin(userId);
        }
        ResponseMsg msg = new ResponseMsg();
        msg.setCode("200");
        msg.setData(cartItems);
        msg.setMsg("返回全部"+(userId==null?"游客":userId+"用户")+"的购物车信息");
        return msg;
    }

    @RequestMapping(value = "/deleteFromCart",method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg deleteFromCart(HttpServletResponse resp,Integer userId,Integer goodsId){
        if(userId==null){
            cartService.deleteFromCart(userId,goodsId,resp);
        }else{
            cartService.deleteFromCartForLogin(userId,goodsId);
        }

        ResponseMsg msg = new ResponseMsg();
        msg.setCode("200");
        msg.setMsg("已删除"+(userId==null?"游客":userId+"用户")+"的"+goodsId+"号商品");
        return msg;
    }

}
