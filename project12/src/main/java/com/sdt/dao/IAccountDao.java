package com.sdt.dao;

import com.sdt.domain.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> findAll();
}
