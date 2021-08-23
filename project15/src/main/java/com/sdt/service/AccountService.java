package com.sdt.service;

import com.sdt.domain.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();

    public void saveAccount(Account account);
}
