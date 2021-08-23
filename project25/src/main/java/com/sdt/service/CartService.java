package com.sdt.service;

import com.sdt.domain.CartForShow;
import com.sdt.domain.CartItem;

import java.util.List;

public interface CartService {
    public void addToCart(CartItem cartItem);

    public CartForShow getAll(Integer userId);

    public boolean modifyGoodsNum(CartItem cartItem);

    public boolean deleteFromCart(Integer cartid,Integer userid);

}
