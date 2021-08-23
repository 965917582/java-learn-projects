package com.sdt.dao;

import com.sdt.bean.Account;

import java.util.List;

public interface IAccountDao {

    public void update(Account user);

    public Account findById(int id);
}
