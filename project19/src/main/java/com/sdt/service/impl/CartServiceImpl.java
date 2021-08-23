package com.sdt.service.impl;

import com.sdt.domain.CartItem;
import com.sdt.domain.Commodit;
import com.sdt.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    Jedis jedis;

    @Override
    public void addToCart(CartItem item) {
        String commId = item.getCommodit().getCommId()+"";
        //获取此商品id的购物车数据
        Map<String, String> redisCommdit = jedis.hgetAll(commId);
        if(redisCommdit.size()!=0){
            jedis.hset(commId,"commoditNum",(item.getCommoditNum()+Integer.parseInt(redisCommdit.get("commoditNum")))+"");
        }else{
            jedis.hset(commId,"commoditNum",item.getCommoditNum()+"");
            jedis.hset(commId,"commoditId",commId);
            jedis.hset(commId,"commoditName",item.getCommodit().getCommName());
            jedis.hset(commId,"commoditPrice",item.getCommodit().getCommPrice()+"");
        }

        System.out.println("购物车条目存入redis成功");

    }

    @Override
    public List<CartItem> findAll() {
        List<CartItem> list = new ArrayList<>();
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            Map<String, String> map = jedis.hgetAll(key);
            CartItem item = new CartItem();
            Commodit commodit = new Commodit();
            commodit.setCommId(Integer.parseInt(map.get("commoditId")));
            commodit.setCommName(map.get("commoditName"));
            commodit.setCommPrice(Double.parseDouble(map.get("commoditPrice")));
            item.setCommoditNum(Integer.parseInt(map.get("commoditNum")));
            item.setCommodit(commodit);
            list.add(item);
        }

        return list;
    }

    @Override
    public void removeFromCart(Integer commId) {
        Map<String, String> map = jedis.hgetAll(commId + "");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            jedis.hdel(commId+"",key);
        }
    }

    @Override
    public void decreaseCommNum(Integer commId) {
        String commoditNum = jedis.hget(commId + "", "commoditNum");
        jedis.hset(commId+"","commoditNum",(Integer.parseInt(commoditNum)-1)+"");
    }

    @Override
    public void increaseCommNum(Integer commId) {
        String commoditNum = jedis.hget(commId + "", "commoditNum");
        jedis.hset(commId+"","commoditNum",(Integer.parseInt(commoditNum)+1)+"");
    }
}
