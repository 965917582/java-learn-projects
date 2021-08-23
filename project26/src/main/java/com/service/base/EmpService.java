package com.service.base;

import com.pojo.base.Emp;

import java.util.List;

public interface EmpService {
    public List<Emp> findAll();

    public void update(Emp emp);

    public void add(Emp emp);

    public void deleteById(Integer empId);


}
