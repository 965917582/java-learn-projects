package com.sdt.service.impl;

import com.sdt.dao.UserDao;
import com.sdt.domain.User;
import com.sdt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.findByNamePsd(user);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }
}
