package com.sdt.dao;


import com.sdt.domain.Commodit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommoditDao {

    public List<Commodit> findAll();

    public Commodit findById(Integer id);
}
