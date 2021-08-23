package com.sdt.controller;

import com.sdt.domain.Account;
import com.sdt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层，查询所有账户");
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);

        return "list";
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        accountService.saveAccount(account);
        resp.sendRedirect(req.getContextPath()+"/account/findAll");
        return ;
    }

}
