package com.GinElmaC.test;

import com.GinElmaC.Bean.HusBand;
import com.GinElmaC.Bean.Wife;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testCycleIoc {
    @Test
    public void testHusAndWife(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        HusBand husBand = applicationContext.getBean("HusBean", HusBand.class);
        Wife wife = applicationContext.getBean("WifeBean", Wife.class);
        System.out.println(husBand);
        System.out.println(wife);

        ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) applicationContext;
        classPathXmlApplicationContext.close();
    }
}
