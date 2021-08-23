package com.sdt.mybatis.sqlsession;

import com.sdt.mybatis.cfg.Configuration;
import com.sdt.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.sdt.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }


}
