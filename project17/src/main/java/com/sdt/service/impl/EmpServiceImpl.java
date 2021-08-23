package com.sdt.service.impl;

import com.sdt.dao.EmpDao;
import com.sdt.domain.Emp;
import com.sdt.service.EmpService;
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
    public void addEmp(Emp emp) {
        empDao.add(emp);
    }

    @Override
    public void updateEmp(Emp emp) {
        empDao.update(emp);
    }

    @Override
    public void deleteEmp(Integer id) {
        empDao.delete(id);
    }

    @Override
    public Emp findById(Integer id) {
        return empDao.findById(id);
    }
}
