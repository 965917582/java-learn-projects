package com.service.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User login(String account, String pwd) {
        List<User> users = userDao.login(account, pwd);
        if(users==null || users.size()==0){
            return null;
        }else{
            return users.get(0);
        }
    }
}
