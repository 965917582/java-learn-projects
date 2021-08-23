package com.sdt.controller;

import com.sdt.bean.Account;
import com.sdt.service.IAccountService;
import com.sdt.service.impl.AccountServiceImpl;
import com.sdt.utils.ProxyFactory;
import com.sdt.utils.ProxyHandler;

import java.lang.reflect.Proxy;

public class AccountController {
    /**
     * 转账
     */
    public void transfer(int account1,int account2,Integer money){
        AccountServiceImpl accountService = new AccountServiceImpl();
        Account accountById1 = accountService.findAccountById(account1);
        Account accountById2 = accountService.findAccountById(account2);

        IAccountService proxy = (IAccountService)ProxyFactory.getProxy(AccountServiceImpl.class);
        proxy.transfer(accountById1,accountById2,money);

    }
}
