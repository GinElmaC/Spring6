package com.GinelmaC.test;

import com.GinElmaC.Service.AccountService;
import com.GinElmaC.Service.OrderService;
import com.GinElmaC.biz.UserService;
import com.GinElmaC.biz.VipService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testspring6 {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        accountService.transfer();
        accountService.drawback();
        orderService.generate();
        orderService.cancel();
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        VipService vipService = applicationContext.getBean("vipService", VipService.class);
        userService.insert();
        userService.delect();
        userService.motify();
        userService.select();
        vipService.insert();
        vipService.delect();
        vipService.motify();
        vipService.select();
    }
}
