package com.service;

import com.pojo.User;

public interface UserService {
    void add(User user);

    User login(String account,String pwd);
}
