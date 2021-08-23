package com.sdt.service.impl;

import com.sdt.bean.Account;
import com.sdt.dao.impl.AccountDaoImpl;
import com.sdt.service.IAccountService;
import com.sdt.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountServiceImpl implements IAccountService {

    @Override
    public void transfer(Account account1, Account account2, int money) {
        account1.setMoney(account1.getMoney()-money);
        account2.setMoney(account2.getMoney()+money);

        AccountDaoImpl accountDao = new AccountDaoImpl();
        Connection conn = JDBCUtils.getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            accountDao.update(account1);
            //int a=1/0;
            accountDao.update(account2);
            conn.commit();
        }catch(Exception e){
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            JDBCUtils.close(null,null);
        }
    }

    @Override
    public Account findAccountById(int id) {
        AccountDaoImpl accountDao = new AccountDaoImpl();
        Account byId = accountDao.findById(id);
        return byId;
    }
}
