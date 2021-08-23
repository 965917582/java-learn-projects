package com.service;

import com.pojo.NotifyUrl;

public interface NotifyUrlService {
    int add(NotifyUrl notifyUrl);

    NotifyUrl findByAppkey(String appkey);
}
