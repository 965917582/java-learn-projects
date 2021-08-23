package com.dao.base;

import com.pojo.base.Dept;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DeptDao {

    public List<Dept> findAll();

    public Dept findById(Integer deptId);

    public void update(Dept dept);

    public void add(Dept dept);

    public void deleteById(Integer deptId);
}
