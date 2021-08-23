package com.dao;

import com.pojo.Torder;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {

    void add(Torder order);
}
