package com.sdt.service;

import com.sdt.domain.Dept;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

public interface DeptService {

    public List<Dept> findAll();

    public void add(Dept dept);

    public void delete(Integer id);

    public void update(Dept dept);

    public Dept findById(Integer id);
}
