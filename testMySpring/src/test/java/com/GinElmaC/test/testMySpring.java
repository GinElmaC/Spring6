package com.GinElmaC.test;

import com.GinElmaC.Bean.Vip;
import org.junit.jupiter.api.Test;
import org.myspringframework.ApplicationContext;
import org.myspringframework.ClassPathXmlApplicationContext;

public class testMySpring {
    @Test
    public void MySpringtest() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Vip vip = (Vip)applicationContext.getBean("vipBean");
        System.out.println(vip);
    }
}
