package com.sdt.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class TestRedis {

    @Test
    public void testRedis(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //设置 redis 字符串数据
        jedis.set("w3ckey", "Redis tutorial");
        // 获取存储的数据并输出
        System.out.println("Stored string in redis:: "+ jedis.get("w3ckey"));
    }
}
