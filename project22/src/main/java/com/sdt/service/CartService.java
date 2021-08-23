package com.sdt.service;

import com.sdt.domain.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CartService {
    /**
     * 处理已登录的添加至购物车
     */
    public void addToCartForLogin(CartItem cartItem);

    /**
     * 处理未登录的添加至购物车
     */
    public void addToCart(CartItem cartItem, HttpServletRequest req, HttpServletResponse resp);

    /**
     * 获取未登录全部购物车数据
     */
    public List<CartItem> getAll(HttpServletRequest req);

    /**
     * 获取已登录全部购物车数据
     */
    public List<CartItem> getAllForLogin(Integer userId);

    /**
     * 未登录，删除一项购物车商品
     */
    public void deleteFromCart(Integer userId,Integer goodsId,HttpServletResponse resp);

    /**
     * 已登录，删除一项购物车商品
     */
    public void deleteFromCartForLogin(Integer userId,Integer goodsId);

    /**
     * 把未登录时的购物车数据合并入服务端购物车
     * 并把未登录购物车数据清除
     */
    public void mergeCart(HttpServletRequest req,Integer userId,HttpServletResponse resp);
}
