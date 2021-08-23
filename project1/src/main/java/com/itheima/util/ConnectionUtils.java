package com.itheima.util;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类，用于从数据库连接池获取连接，并且和线程绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource=dataSource;
    }

    /**
     * 获取当前线程上的连接
     */
    public Connection getThreadConnection(){
        try{
            Connection conn = tl.get();
            if(conn==null){
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            return conn;
        }catch(Exception e){
            throw new RuntimeException();
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }

}

































