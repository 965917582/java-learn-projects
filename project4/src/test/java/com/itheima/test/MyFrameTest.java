package com.itheima.test;

import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import com.itheima.util.MyContext;
import org.junit.Test;

public class MyFrameTest {

    @Test
    public void test(){
        MyContext myContext = new MyContext("/spring.xml");
        AccountServiceImpl bean = (AccountServiceImpl)myContext.getBean(AccountServiceImpl.class);
        bean.testmethod();
        //Object accountDao = myContext.getBean("accountDao");
        //IAccountService accountService = (AccountServiceImpl)myContext.getBean("accountService");
        //accountService.testmethod();

    }
}
