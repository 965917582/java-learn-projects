package com.sdt.service.impl;

import com.sdt.dao.CommoditDao;
import com.sdt.domain.Commodit;
import com.sdt.service.CommoditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommoditServiceImpl implements CommoditService {
    @Autowired
    CommoditDao commoditDao;

    @Override
    public List<Commodit> findAll() {
        return commoditDao.findAll();
    }

    @Override
    public Commodit findById(Integer id) {
        return commoditDao.findById(id);
    }
}
