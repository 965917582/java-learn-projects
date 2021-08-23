package com.sdt.utils;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class Pool {
    //容器
    static Map map = new HashMap<Long, Connection>();
    //放入连接
    public static void putConn(Connection conn){
        map.put(Thread.currentThread().getId(),conn);
    }

    //获取连接
    public static Connection getConn(){
        return (Connection)map.get(Thread.currentThread().getId());
    }

    //移除连接
    public static Connection removeConn(Long id){
        return (Connection)map.remove(id);
    }

}
