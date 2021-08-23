package com.dao;

import com.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    void add(User user);

    List<User> login(String account, String pwd);
}
