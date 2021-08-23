package com.sdt.service;

import com.sdt.domain.CartItem;

import java.util.List;

public interface CartService {

    /**
     * 添加一条购物车条目进购物车
     * 此时购物车数据不是用户最终提交数据，所以暂存在缓存
     */
    public void addToCart(CartItem item);

    /**
     * 从缓存取出全部购物车条目
     */
    public List<CartItem> findAll();

    /**
     * 移除指定商品的购物车条目
     */
    public void removeFromCart(Integer commId);

    /**
     * 指定商品数量减少1
     */
    public void decreaseCommNum(Integer commId);

    /**
     * 指定商品数量增加1
     */
    public void increaseCommNum(Integer commId);
}
