package com.sdt.dao;

import com.sdt.domain.OrderDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDao {

    public void add(OrderDetail orderDetail);

    public void deleteByOrderId(Integer orderId);
}
