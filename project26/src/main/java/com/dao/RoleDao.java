package com.dao;

import com.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    //获取全部
    public List<Role> findAll();


}
