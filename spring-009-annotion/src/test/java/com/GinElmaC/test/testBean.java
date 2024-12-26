package com.GinElmaC.test;

import com.GinElmaC.Auto.Impl.OrderDaoImle2;
import com.GinElmaC.Auto.Impl.OrderDaoImpl;
import com.GinElmaC.Auto.OrderDao;
import com.GinElmaC.Auto.Service.orderService;
import com.GinElmaC.Auto.spring6Config;
import com.GinElmaC.Bean.A;
import com.GinElmaC.Bean.User;
import com.GinElmaC.Bean.Vip;
import com.GinElmaC.Bean2.MyDataSource;
import com.GinElmaC.re.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testBean {
    @Test
    public void test1(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(spring6Config.class);
        OrderDao orderDao = annotationConfigApplicationContext.getBean("orderDaoImpl", OrderDaoImpl.class);
        orderDao.insert();
    }
    @Test
    public void testCom(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }
    @Test
    public void testByValue(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springBy.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }
    @Test
    public void testAuto(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springAutoWired.xml");
        orderService orderService = applicationContext.getBean("orderService",com.GinElmaC.Auto.Service.orderService.class);
        orderService.service();
    }
    @Test
    public void testRe(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springResource.xml");
        StudentService service = applicationContext.getBean("studentService", StudentService.class);
        service.service();
    }
}
