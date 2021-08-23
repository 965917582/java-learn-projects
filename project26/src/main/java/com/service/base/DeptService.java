package com.service.base;

import com.pojo.base.Dept;

import java.util.List;

public interface DeptService {

    public List<Dept> findAll();

    public void update(Dept dept);

    public void add(Dept dept);

    public void deleteById(Integer deptId);
}
