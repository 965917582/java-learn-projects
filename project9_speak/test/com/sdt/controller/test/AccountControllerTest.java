package com.sdt.controller.test;

import com.sdt.bean.Account;
import com.sdt.controller.AccountController;

public class AccountControllerTest {

    public static void main(String[] args) {
        AccountController accountController = new AccountController();
        accountController.transfer(1,2,100);
    }
}
