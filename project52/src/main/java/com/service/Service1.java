package com.service;

import com.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Service1 {

    public void method1()  {
        System.out.println("service1-method1");
        //获取连接
        Connection conn = JDBCUtils.getConnection();
        //操作一次数据库:1减3元
        try{
            String sql="update account set money=? where id=?";
            PreparedStatement pstmt =null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,-3);
            pstmt.setInt(2,1);
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }


        //异常
        int a = 1/0;

        //操作一次数据库：2加3元
        try{
            String sql2="update account set money=? where id=?";
            PreparedStatement pstmt2 =null;
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setInt(1,3);
            pstmt2.setInt(2,2);
            pstmt2.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }

    }

    public void method2(){
        System.out.println("service1-method2");
    }

}
