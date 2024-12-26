package com.GinElmaC.test;

import com.GinElmaC.bank.Pojo.Account;
import com.GinElmaC.bank.Service.AccountService;
import com.GinElmaC.bank.Service.ServiceImpl.IsolationService1;
import com.GinElmaC.bank.Service.ServiceImpl.IsolationService2;
import com.GinElmaC.bank.spring6config;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class testBank {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
        try{
            accountService.transfer("act-001","act-002",10000);
            System.out.println("转账成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        Account act = new Account("act-003",10000.00);
        accountService.save(act);
    }
    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService1 i1 = applicationContext.getBean("i1", IsolationService1.class);
        i1.selectByActno("act-004");
    }
    @Test
    public void test32(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 i2 = applicationContext.getBean("i2", IsolationService2.class);
        Account account = new Account("act-004",10000.00);
        i2.save(account);
    }
    @Test
    public void test4(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(spring6config.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act-001","act-002",10000.00);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
