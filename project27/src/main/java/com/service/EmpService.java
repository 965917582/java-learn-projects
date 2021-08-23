package com.service;

import com.pojo.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> findAll(Emp emp);

    Emp findByEmpId(Integer empId);

    void add(Emp emp);

    void add2(Emp emp);

    void update(Emp emp);
}
