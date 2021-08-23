package com.dao;


import com.pojo.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    //查所有菜单
    public List<Menu> findAll();

}
