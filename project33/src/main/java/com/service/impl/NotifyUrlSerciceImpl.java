package com.service.impl;

import com.dao.NotifyUrlDao;
import com.pojo.NotifyUrl;
import com.service.NotifyUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifyUrlSerciceImpl implements NotifyUrlService {
    @Autowired
    NotifyUrlDao notifyUrlDao;
    @Override
    public int add(NotifyUrl notifyUrl) {
        return notifyUrlDao.add(notifyUrl);
    }

    @Override
    public NotifyUrl findByAppkey(String appkey) {
        return notifyUrlDao.findByAppkey(appkey);
    }
}
