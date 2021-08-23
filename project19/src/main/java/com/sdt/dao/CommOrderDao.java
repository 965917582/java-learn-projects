package com.sdt.dao;

import com.sdt.domain.CommOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface CommOrderDao {
    public void add(CommOrder commOrder);

    public void deleteOrderById(Integer orderId);
}
