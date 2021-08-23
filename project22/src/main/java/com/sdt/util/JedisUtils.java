package com.sdt.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {

    static JedisPool pool = null;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMaxWaitMillis(13000);
        config.setMaxIdle(2);
        pool = new JedisPool();
    }
    //getJedis方法
    public static Jedis getJedis() {
        return pool.getResource();
    }
}
