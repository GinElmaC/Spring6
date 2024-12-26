package com.GinElmaC.MyTest;

import com.GinElmaC.Bean.Springbean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOne {
    @Test
    public void TestIt(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        Springbean springbean1 = applicationContext.getBean("sb", Springbean.class);
        System.out.println(springbean1);
        Springbean springbean2 = applicationContext.getBean("sb", Springbean.class);
        System.out.println(springbean2);
        Springbean springbean3 = applicationContext.getBean("sb", Springbean.class);
        System.out.println(springbean3);
    }
    @Test
    public void TestThreadScope(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        Springbean sb = applicationContext.getBean("sb", Springbean.class);
        System.out.println(sb);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Springbean sb1 = applicationContext.getBean("sb", Springbean.class);
                System.out.println(sb1);
            }
        }).start();
    }
}
