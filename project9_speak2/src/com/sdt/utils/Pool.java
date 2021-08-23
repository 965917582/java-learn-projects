package com.sdt.utils;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class Pool {
    //容器
    static Map map = new HashMap<Long, Connection>();

    //存放连接
    public static void putConn(Connection conn){
        map.put(Thread.currentThread().getId(),conn);
    }

    //获取连接
    public static Connection getConn(){
        return (Connection)map.get(Thread.currentThread().getId());
    }

    //移除连接
    public static Connection removeConn(){
        return (Connection)map.remove(Thread.currentThread().getId());
    }


}
