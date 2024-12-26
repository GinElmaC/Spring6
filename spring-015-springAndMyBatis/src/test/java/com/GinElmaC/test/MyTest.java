package com.GinElmaC.test;

import com.GinElmaC.Pojo.Account;
import com.GinElmaC.Service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountSerivce", AccountService.class);
        Account account = new Account("act-003",30000.00);
        accountService.save(account);
    }
}
