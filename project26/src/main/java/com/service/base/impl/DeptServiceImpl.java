package com.service.base.impl;

import com.dao.base.DeptDao;
import com.pojo.base.Dept;
import com.service.base.DeptService;
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
    public void update(Dept dept) {
        deptDao.update(dept);
    }

    @Override
    public void add(Dept dept) {
        deptDao.add(dept);
    }

    @Override
    public void deleteById(Integer deptId) {
        deptDao.deleteById(deptId);
    }
}
