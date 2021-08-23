package com.service.impl;

import com.dao.DeptDao;
import com.pojo.Dept;
import com.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptDao deptDao;
    @Override
    public List<Dept> findAll(Dept dept) {

        return deptDao.findAll(dept);
    }

    @Override
    public Dept findById(Integer deptId) {
        return deptDao.findById(deptId);
    }


    @Override
    public void add(Dept dept) {
        deptDao.add(dept);
    }

    @Override
    public void update(Dept dept) {
        deptDao.update(dept);
    }

    public void deleteByDeptId(Integer deptId){
        deptDao.deleteByDeptId(deptId);
    }
}
