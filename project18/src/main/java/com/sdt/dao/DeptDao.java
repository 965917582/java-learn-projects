package com.sdt.dao;

import com.sdt.domain.Dept;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptDao {
    public List<Dept> findAll();

    public void add(Dept dept);

    public void delete(Integer id);

    public void update(Dept dept);

    public Dept findById(Integer id);
}
