package com.sdt.test;

import com.sdt.dao.AccountDao;
import com.sdt.domain.Account;
import com.sdt.service.impl.AccountServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run1() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        AccountDao dao = session.getMapper(AccountDao.class);
        List<Account> all =  dao.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
        session.close();
        is.close();
    }


}
