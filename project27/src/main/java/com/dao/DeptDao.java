package com.dao;

import com.pojo.Dept;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DeptDao {

    List<Dept> findAll(Dept dept);

    Dept findById(Integer deptId);

    void add(Dept dept);

    void update(Dept dept);

    void deleteByDeptId(Integer deptId);
}
