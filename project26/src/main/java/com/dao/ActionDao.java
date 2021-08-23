package com.dao;

import com.pojo.Action;

import java.util.List;

public interface ActionDao {
    //查所有
    public List<Action> findAll();

    //根据菜单获取动作
    public List<Action> findByMenuId(Integer menuId);

}
