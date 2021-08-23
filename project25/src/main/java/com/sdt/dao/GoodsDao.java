package com.sdt.dao;

import com.sdt.domain.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {
    public List<Goods> findAll();

    public Goods findGoodsbyId(Integer goodsId);
}
