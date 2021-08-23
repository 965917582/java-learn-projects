package com.project54.com.controller;

import com.project54.com.bean.Account;
import com.project54.com.dao.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AccountMapper accountMapper;

    @RequestMapping("/queryAll")
    public List<Map<String, Object>> queryAll(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from account");
        return list;
    }

    @RequestMapping("/addMoney")
    public boolean addMoney(Integer id,Integer money) throws InterruptedException {
        Account account = accountMapper.getById(id);
        //模拟充值中
        long waittime = (long)(Math.random()*10000);
        System.out.println(Thread.currentThread().getId()+"充值中："+waittime+",版本为："+account.getVersion());
        Thread.sleep(waittime);

        account.setMoney(account.getMoney()+money);
        int update = accountMapper.update(account);
        if(update>0) System.out.println(Thread.currentThread().getId()+"充值成功");
        else System.out.println(Thread.currentThread().getId()+"充值失败");
        return update>0?true:false;

    }




}
