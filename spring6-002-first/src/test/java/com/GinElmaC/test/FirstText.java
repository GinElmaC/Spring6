package com.GinElmaC.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstText {
    @Test
    public void testFirst(){
        //获取spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //根据bean的id获取这个对象
        Object object = applicationContext.getBean("UserBean");
        System.out.println(object);

        Object object1 = applicationContext.getBean("DateBean");
        System.out.println(object1);

        Logger logger = LoggerFactory.getLogger(FirstText.class);
        logger.info("info级别");
        logger.debug("dubug级别");
        logger.error("error级别");
    }
}
