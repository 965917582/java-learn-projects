package com;
//通知类
//增强功能：事务

import java.sql.Connection;
import java.sql.SQLException;

public class Advice {

    //前置通知
    public void setAutoCommit() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        connection.setAutoCommit(false);
    }

    //后置通知
    public void commit() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        connection.commit();
    }

    //异常通知
    public void rollback() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        connection.rollback();
    }

    //最终通知
    public void closeConn(){
        Connection connection = JDBCUtils.getConnection();
        JDBCUtils.close(connection,null,null);
    }

}
