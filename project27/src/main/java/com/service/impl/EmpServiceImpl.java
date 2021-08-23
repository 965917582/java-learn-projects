package com.service.impl;

import com.dao.EmpDao;
import com.pojo.Emp;
import com.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpDao empDao;

    @Override
    public List<Emp> findAll(Emp emp) {
        return empDao.findAll(emp);
    }

    @Override
    public Emp findByEmpId(Integer empId) {
        return empDao.findByEmpId(empId);
    }

    @Override
    public void add(Emp emp) {
        empDao.add(emp);
    }

    @Override
    public void add2(Emp emp) {
        empDao.add2(emp);
    }

    @Override
    public void update(Emp emp) {
        empDao.update(emp);
    }


}
