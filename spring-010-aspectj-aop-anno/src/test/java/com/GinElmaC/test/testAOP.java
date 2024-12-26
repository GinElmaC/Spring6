package com.GinElmaC.test;


import com.GinElmaC.service.OrderService;
import com.GinElmaC.service.Spring6Config;
import com.GinElmaC.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAOP {
    @Test
    public void testnoXML(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        userService.login();
//        userService.logout();
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }
}
