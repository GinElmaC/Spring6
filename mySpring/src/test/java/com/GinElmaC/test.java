package com.GinElmaC;

import org.junit.jupiter.api.Test;
import org.myspringframework.ApplicationContext;
import org.myspringframework.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void testit() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }

}
