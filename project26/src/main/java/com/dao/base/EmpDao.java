package com.dao.base;

import com.pojo.base.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpDao {
    public List<Emp> findAll();

    public Emp findById(Integer empId);

    public void update(Emp emp);

    public void add(Emp emp);

    public void deleteById(Integer empId);


}
