package com.sdt.utils;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据库连接池
 *
 */
public class Local {
	//容器
	static Map<Long ,Connection> map = new HashMap<Long ,Connection>();
	//放入连接
	public static void setConnection(Connection conn){
		map.put(Thread.currentThread().getId(), conn);
	}
	
	//获取连接
	public static Connection getConnection(Long id){
		return map.get(id);
	}
	
	//移除连接
	public static Connection removeConnection(Long id){
		return map.remove(id);
	}
}
