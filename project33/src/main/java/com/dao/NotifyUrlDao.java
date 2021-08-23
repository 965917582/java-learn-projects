package com.dao;

import com.pojo.NotifyUrl;
import org.springframework.stereotype.Repository;

@Repository
public interface NotifyUrlDao {
    int add(NotifyUrl notifyUrl);

    NotifyUrl findByAppkey(String appkey);
}
