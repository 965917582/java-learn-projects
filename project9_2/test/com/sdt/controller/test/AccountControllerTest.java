package com.sdt.controller.test;

import com.sdt.bean.Account;
import com.sdt.controller.AccountController;

import java.sql.SQLException;

public class AccountControllerTest {

    public static void main(String[] args)  {
       /* Account account1 = new Account();
        account1.setId(1);
        account1.setMoney(1000d);
        Account account2 = new Account();
        account2.setId(2);
        account2.setMoney(1000d);
*/

        AccountController accountController = new AccountController();
        accountController.transfer(1,2,100);

    }
}
