package com.sdt.service;

import com.sdt.bean.Account;

public interface IAccountService {
    public void transfer(Account account1, Account account2, int money);

    public Account findAccountById(int id);
}
