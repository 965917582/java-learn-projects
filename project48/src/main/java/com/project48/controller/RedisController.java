package com.project48.controller;

import com.project48.util.LZHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;
    //需要根据名称来注入
    @Resource(name = "secondRedisTemplate")
    private RedisTemplate secondRedisTemplate;

    @GetMapping("/setUser")
    public String setUser(String name,String value){
        String node = LZHash.getRedisNode(name);
        if("127.0.0.1:6379".equals(node)){
            redisTemplate.opsForValue().set(name, value, 5, TimeUnit.MINUTES);
        }else if("127.0.0.1:6380".equals(node)){
            secondRedisTemplate.opsForValue().set(name, value, 5, TimeUnit.MINUTES);
        }
        return "节点"+node+"设置成功";
    }

    @GetMapping("/getUser")
    public String getUser(String name){
        String node = LZHash.getRedisNode(name);
        String value = null;
        if("127.0.0.1:6379".equals(node)){
            value = (String)redisTemplate.opsForValue().get(name);
        }else if("127.0.0.1:6380".equals(node)){
            value = (String)secondRedisTemplate.opsForValue().get(name);
        }
        return "节点"+node+"值为"+value;
    }
}
