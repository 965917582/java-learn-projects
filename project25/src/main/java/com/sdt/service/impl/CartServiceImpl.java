package com.sdt.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdt.dao.GoodsDao;
import com.sdt.domain.CartForShow;
import com.sdt.domain.CartItem;
import com.sdt.domain.CartItemForShow;
import com.sdt.domain.Goods;
import com.sdt.service.CartService;
import com.sdt.util.JedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    Jedis jedis = JedisUtils.getJedis();
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    GoodsDao goodsDao;

    @Override
    public void addToCart(CartItem cartItem) {
        //userid:cartItem的json，存进redis
        String cartItemStr = null;
        String goodsJson = jedis.hget(cartItem.getUserid() + "", cartItem.getShopid() + "");
        //todo 判断用户id合法

        if(goodsJson==null){
            //直接转换参数的购物车对象
            try{
                cartItemStr = objectMapper.writeValueAsString(cartItem);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            //获取原有数量
            CartItem cartItemOld = null;
            try{
                cartItemOld = objectMapper.readValue(goodsJson, CartItem.class);
            }catch (Exception e){
                e.printStackTrace();
            }
            //设置新数量
            cartItem.setShopnum(cartItem.getShopnum()+cartItemOld.getShopnum());
            //转换修改后的参数的购物车对象
            try{
                cartItemStr = objectMapper.writeValueAsString(cartItem);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        jedis.hset(cartItem.getUserid()+"",cartItem.getShopid()+"",cartItemStr);

    }


    @Override
    public boolean modifyGoodsNum(CartItem cartItem) {
        //获得此商品
        String goodsJson = jedis.hget(cartItem.getUserid() + "", cartItem.getShopid() + "");
        if(goodsJson==null){
            return false;
        }

        //覆盖数量
        CartItem cartItemOld = null;
        try{
            cartItemOld = objectMapper.readValue(goodsJson, CartItem.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        //设置新数量
        cartItem.setShopnum(cartItem.getShopnum());
        //转换修改后的参数的购物车对象
        String cartItemStr = null;
        try{
            cartItemStr = objectMapper.writeValueAsString(cartItem);
        }catch (Exception e){
            e.printStackTrace();
        }
        jedis.hset(cartItem.getUserid()+"",cartItem.getShopid()+"",cartItemStr);

        return true;
    }

    @Override
    public boolean deleteFromCart(Integer cartid, Integer userid) {
        String hget = jedis.hget(userid + "", cartid + "");
        if(hget==null){
            return false;
        }
        jedis.hdel(userid+"",cartid+"");
        return true;
    }

    @Override
    public CartForShow getAll(Integer userId) {
        CartForShow cartForShow = new CartForShow();
        List<CartItemForShow> list = new ArrayList<>();
        BigDecimal total=BigDecimal.ZERO;;
        //得到此用户的购物车数据，
        //对每条数据，查询得到商品具体信息
        //并计算总价
        Map<String, String> cartItemStrs = jedis.hgetAll(userId + "");//商品id:商品json
        Set<String> keySet = cartItemStrs.keySet();
        if(keySet!=null){
            for (String key : keySet) {
                String carItemJson = cartItemStrs.get(key);
                CartItem cartItem = null;
                try{
                    cartItem = objectMapper.readValue(carItemJson, CartItem.class);
                }catch (Exception e){
                    e.printStackTrace();
                }
                //获取商品具体信息
                Goods goods = goodsDao.findGoodsbyId(cartItem.getShopid());
                CartItemForShow cartItemForShow = new CartItemForShow();
                cartItemForShow.setCartid(cartItem.getShopid());
                cartItemForShow.setGuige(goods.getGuige());
                cartItemForShow.setPrice(goods.getPrice());
                cartItemForShow.setShopname(goods.getShopname());
                cartItemForShow.setShopnum(cartItem.getShopnum());
                cartItemForShow.setShoppic(goods.getShoppic());

                list.add(cartItemForShow);
                BigDecimal tmp = goods.getPrice().multiply(BigDecimal.valueOf(Double.parseDouble(cartItem.getShopnum()+"")));
                total = total.add(tmp);

            }
        }

        cartForShow.setShoplist(list);
        cartForShow.setTotalpri(total);
        return cartForShow;
    }
}
