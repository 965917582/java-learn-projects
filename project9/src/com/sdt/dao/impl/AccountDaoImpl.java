package com.sdt.dao.impl;

import com.sdt.bean.Account;
import com.sdt.dao.IAccountDao;
import com.sdt.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    @Override
    public void update(Account account) {
        Connection conn = JDBCUtils.getConnection();
        String sql="update account set money=? where id=?";
        PreparedStatement pstmt =null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1,account.getMoney());
            pstmt.setInt(2,account.getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.close(conn,null, pstmt);
        }
    }

    @Override
    public Account findById(int id) {
        Connection conn = JDBCUtils.getConnection();
        String sql="select * from account where id=?;";
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        Account account = new Account();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                account.setId(rs.getInt(1));
                account.setMoney(rs.getDouble(2));
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //JDBCUtils.close(rs, pstmt);
        }

        return account;
    }
}
