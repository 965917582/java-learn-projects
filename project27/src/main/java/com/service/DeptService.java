package com.service;

import com.pojo.Dept;

import java.util.Date;
import java.util.List;

public interface DeptService {
    List<Dept> findAll(Dept dept);

    Dept findById(Integer deptId);

    void add(Dept dept);

    void update(Dept dept);

    void deleteByDeptId(Integer deptId);
}
