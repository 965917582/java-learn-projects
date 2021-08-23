package com.sdt.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdt.domain.CartItem;
import com.sdt.domain.Goods;
import com.sdt.service.CartService;
import com.sdt.util.JedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 购物车数据结构：
 * 键：用户id
 * 值：哈希(键：商品id  值：商品json)
 */
@Service
public class CartServiceImpl implements CartService {

    //@Autowired
    Jedis jedis = JedisUtils.getJedis();
    @Autowired
    ObjectMapper objectMapper;

    //Java 8的java.util套件中的base编码解码器，为json字符串编码以存入cookie
    Base64.Decoder decoder = Base64.getDecoder();
    Base64.Encoder encoder = Base64.getEncoder();

    /**
     * 对于已登录，与redis交互
     * 添加本项到购物车
     * 若此用户的购物车已有此项商品，修改数量。若没有，直接添加
     */
    @Override
    public void addToCartForLogin(CartItem cartItem) {

        String cartItemStr = null;

        //System.out.println(cartItemStr);
        String goodsJson = jedis.hget(cartItem.getUserId() + "", cartItem.getGoodsId() + "");
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
            cartItem.setGoodsNum(cartItem.getGoodsNum()+cartItemOld.getGoodsNum());
            //转换修改后的参数的购物车对象
            try{
                cartItemStr = objectMapper.writeValueAsString(cartItem);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        jedis.hset(cartItem.getUserId()+"",cartItem.getGoodsId()+"",cartItemStr);


    }

    /**
     * 对于未登录，
     * 判断是否已有此商品，与cookie交互
     * 若已有，累加数量。若没有，直接添加
     *
     * 注意：json字符串存入cookie使用base64编码(因为json含不能存入cookie的字符)
     */
    @Override
    public void addToCart(CartItem cartItem, HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        if(cookies!=null && cookies.length!=0){
            for (Cookie cookie : cookies) {
                if(("cartItem"+cartItem.getGoodsId()).equals(cookie.getName())){
                    String cartItemOldStr = null;
                    CartItem cartItemOld = null;
                    try{
                        cartItemOldStr = new String(decoder.decode(cookie.getValue()), "UTF-8");
                        cartItemOld = objectMapper.readValue(cartItemOldStr, CartItem.class);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    cartItem.setGoodsNum(cartItem.getGoodsNum()+cartItemOld.getGoodsNum());
                    break;
                }
            }
        }


        String cartItemStr = null;
        String encodedText = null;
        try{
            cartItemStr = objectMapper.writeValueAsString(cartItem);
            byte[] bytes = cartItemStr.getBytes("UTF-8");
            encodedText = encoder.encodeToString(bytes);
            //System.out.println(encodedText);
            //System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
        }catch (Exception e){
            e.printStackTrace();
        }
        Cookie cookie = new Cookie("cartItem"+String.valueOf(cartItem.getGoodsId()), encodedText);
        cookie.setPath("/");
        try{
            resp.addCookie(cookie);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public List<CartItem> getAllForLogin(Integer userId) {
        List<CartItem> list = new ArrayList<CartItem>();
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
                list.add(cartItem);
            }
        }

        return list;
    }

    /**
     * 解决方案：
     * 可以客户端直接获取cookie显示，控制器返回一个提示告知前端
     * 可以服务端获得cookie解析出对象列表返回，这样客户端代码不用作修改[选用]
     *
     */
    @Override
    public List<CartItem> getAll(HttpServletRequest req) {
        List<CartItem> list = new ArrayList<>();
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                //若为购物车条目cookie
                if(cookie.getName().contains("cartItem")){
                    String cartItemOldStr = null;
                    CartItem cartItem = null;
                    try{
                        cartItemOldStr = new String(decoder.decode(cookie.getValue()), "UTF-8");
                        cartItem = objectMapper.readValue(cartItemOldStr, CartItem.class);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    list.add(cartItem);
                }
            }
        }

        return list;
    }


    @Override
    public void deleteFromCartForLogin(Integer userId, Integer goodsId) {
        jedis.hdel(userId+"",goodsId+"");
    }

    @Override
    public void deleteFromCart(Integer userId, Integer goodsId,HttpServletResponse resp) {
        Cookie cookie = new Cookie("cartItem" + goodsId, "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        resp.addCookie(cookie);
    }

    @Override
    public void mergeCart(HttpServletRequest req,Integer userId,HttpServletResponse resp) {
        List<CartItem> cartItemsInClient=this.getAll(req);;
        List<CartItem> cartItemsInServer=getAllForLogin(userId);

        //不存在的商品做添加，存在的商品合并商品数量
        boolean flag;//客户端购物车商品项是否在服务端存在
        for (CartItem cartItemClient : cartItemsInClient) {
            flag = false;
            for (CartItem cartItemServer : cartItemsInServer) {
                if(cartItemClient.getGoodsId()==cartItemServer.getGoodsId()){
                    flag = true;
                    cartItemServer.setGoodsNum(cartItemServer.getGoodsNum()+cartItemClient.getGoodsNum());
                }
            }
            //若不存在
            if(flag==false){
                cartItemClient.setUserId(userId);
                cartItemsInServer.add(cartItemClient);
            }
            //清除客户端数据
            this.deleteFromCart(userId,cartItemClient.getGoodsId(),resp);
        }
        //把修改后的数据存入服务端
        //清除此用户购物车数据
        jedis.del(userId+"");
        for (CartItem cartItem : cartItemsInServer) {
            this.addToCartForLogin(cartItem);
        }


    }
}
