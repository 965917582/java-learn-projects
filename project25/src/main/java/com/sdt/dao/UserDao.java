package com.sdt.dao;

import com.sdt.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User findByNamePsd(User user);

    public void add(User user);
}
