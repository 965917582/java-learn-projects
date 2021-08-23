package com.dao;

import com.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User findByNamePsd(User user);
}
