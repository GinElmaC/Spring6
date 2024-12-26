package com.ElmaC.Test;

import com.GinElmaC.Bean.Class;
import com.GinElmaC.Bean.Dog;
import com.GinElmaC.Bean.Student;
import com.GinElmaC.Bean.persion;
import com.GinElmaC.Service.CustomerService;
import com.GinElmaC.Service.UserService;
import com.GinElmaC.Service.orderService;
import com.GinElmaC.jdbc.MyDateSource;
import com.GinElmaC.jdbc.MyDateSource1;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestFirst {
    @Test
    public void testthis(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("UserServiceBean", UserService.class);
        userService.saveUser();
    }
    @Test
    public void testTwo(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        CustomerService customerService = applicationContext.getBean("CustomerServiceBean",CustomerService.class);

    }
    @Test
    public void ordertest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        orderService orderService = applicationContext.getBean("orderServiceBean",com.GinElmaC.Service.orderService.class);
        orderService.generate();
    }
    @Test
    public void myDateSource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MyDateSource myDateSource = applicationContext.getBean("DateSourceBean",MyDateSource.class);
        System.out.println(myDateSource);
    }
    @Test
    public void testcascade(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cascade.xml");
        Class ct = applicationContext.getBean("classBean",Class.class);
        Student student = applicationContext.getBean("studentBean",Student.class);
        System.out.println(student);
        System.out.println(ct);
    }
    @Test
    public void testpersion(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springCollection.xml");
        persion p = applicationContext.getBean("persionBean", persion.class);
        System.out.println(p);
    }
    @Test
    public void testp(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog d = applicationContext.getBean("dogBean",Dog.class);
        System.out.println(d);
    }
    @Test
    public void testUtil(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDateSource1 myDateSource1 = applicationContext.getBean("MyDataSource1Bean", MyDateSource1.class);
        System.out.println(myDateSource1);
    }
    @Test
    public void testjdbc(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-propeaties.xml");
        MyDateSource myDateSource = applicationContext.getBean("ds", MyDateSource.class);
        System.out.println(myDateSource);
    }
}
