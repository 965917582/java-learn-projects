package com.service.impl;

import com.dao.MenuDao;
import com.pojo.Menu;
import com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> findAll() {
        return menuDao.findAll();
    }
}
