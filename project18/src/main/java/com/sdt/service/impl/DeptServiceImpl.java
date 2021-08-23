package com.sdt.service.impl;

import com.sdt.dao.DeptDao;
import com.sdt.domain.Dept;
import com.sdt.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptDao deptDao;

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    @Override
    public void add(Dept dept) {
        deptDao.add(dept);
    }

    @Override
    public void delete(Integer id) {
        deptDao.delete(id);
    }

    @Override
    public void update(Dept dept) {
        deptDao.update(dept);
    }

    @Override
    public Dept findById(Integer id) {
        return deptDao.findById(id);
    }
}
