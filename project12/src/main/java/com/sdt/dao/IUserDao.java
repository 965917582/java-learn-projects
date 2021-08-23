package com.sdt.dao;

import com.sdt.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

    User findById(Integer userId);
}
