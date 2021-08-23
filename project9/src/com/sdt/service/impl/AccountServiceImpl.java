package com.sdt.service.impl;

import com.sdt.bean.Account;
import com.sdt.dao.impl.AccountDaoImpl;
import com.sdt.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    AccountDaoImpl accountDao = new AccountDaoImpl();

    @Override
    public void transfer(Account account1, Account account2, int money) {
        account1.setMoney(account1.getMoney()-money);
        account2.setMoney(account2.getMoney()+money);

        accountDao.update(account1);
        int a=1/0;
        accountDao.update(account2);
    }

    @Override
    public Account findAccountById(int id) {
        AccountDaoImpl accountDao = new AccountDaoImpl();
        Account byId = accountDao.findById(id);
        return byId;
    }
}
