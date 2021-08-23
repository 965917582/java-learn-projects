package com.sdt.service.impl;

import com.sdt.dao.GoodsDao;
import com.sdt.domain.Goods;
import com.sdt.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<Goods> findAll() {
        return goodsDao.findAll();
    }
}
