package com.sdt.controller;

import com.sdt.bean.Account;
import com.sdt.service.impl.AccountServiceImpl;

public class AccountController {
    /**
     * 转账
     */
    AccountServiceImpl accountService = new AccountServiceImpl();

    public void transfer(int account1,int account2,Integer money){

        Account accountById1 = accountService.findAccountById(account1);
        Account accountById2 = accountService.findAccountById(account2);
        accountService.transfer(accountById1,accountById2,money);
    }
}
