package com.sdt.service;

import com.sdt.domain.Emp;

import java.util.List;

public interface EmpService {

    public List<Emp> findAll();

    public void addEmp(Emp emp);

    public void updateEmp(Emp emp);

    public void deleteEmp(Integer id);

    public Emp findById(Integer id);
}
