package com.dao;

import com.pojo.Emp;

import java.util.List;

public interface EmpDao {

    List<Emp> findAll(Emp emp);

    Emp findByEmpId(Integer empId);

    void add(Emp emp);

    void add2(Emp emp);

    void update(Emp emp);
}
