package com.sdt.service;

import com.sdt.domain.CartItem;
import com.sdt.domain.Commodit;

import java.util.List;

public interface CommoditService {

    public List<Commodit> findAll();

    public Commodit findById(Integer id);


}
