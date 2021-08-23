package com.service.base.impl;

import com.dao.base.EmpDao;
import com.pojo.base.Emp;
import com.service.base.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpDao empDao;

    @Override
    public List<Emp> findAll() {
        return empDao.findAll();
    }

    @Override
    public void update(Emp emp) {
        empDao.update(emp);
    }

    @Override
    public void add(Emp emp) {
        empDao.add(emp);
    }

    @Override
    public void deleteById(Integer empId) {
        empDao.deleteById(empId);
    }
}
