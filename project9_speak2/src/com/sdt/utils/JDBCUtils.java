package com.sdt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * JDBC工具类 
 */
public class JDBCUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

    static {
    	//读取配置文件
    	ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    	driver = bundle.getString("driver");
    	url = bundle.getString("url");
    	username = bundle.getString("username");
    	password = bundle.getString("password");
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    //获取数据库连接
    public static Connection getConnection(){
		Connection conn = Pool.getConn();
		if(conn==null){
			try{
				conn = DriverManager.getConnection(url, username, password);
			}catch (Exception e){
				e.printStackTrace();
			}
			Pool.putConn(conn);
		}
		return conn;
    }
    
    //释放资源
    public static void close(Connection conn,ResultSet rs,Statement stmt){
    	
    	if(rs!=null){
    		try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	if(stmt!=null){
    		try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	if(conn!=null){
			try {
				conn = Pool.removeConn();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

    }


}
