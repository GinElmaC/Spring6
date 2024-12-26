package com.GinElmaC.test;

import com.GinElmaC.Gun;
import com.GinElmaC.Persion;
import com.GinElmaC.Star;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testBean {
    @Test
    public void testFactory(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Star star = applicationContext.getBean("starBean",Star.class);
        System.out.println(star);
    }
    @Test
    public void testGun(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = applicationContext.getBean("gunBean",Gun.class);
        System.out.println(gun);
    }
    @Test
    public void testPersion(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Persion persion = applicationContext.getBean("persionBean",Persion.class);
        System.out.println(persion);
    }
    @Test
    public void testBeanFactory(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");
        Persion persion = beanFactory.getBean("persionBean", Persion.class);
        System.out.println(persion);
    }
    @Test
    public void testdate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Persion persion = applicationContext.getBean("persion", Persion.class);
        System.out.println(persion);

        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("spring.xml");
        Persion persion2 = applicationContext2.getBean("persion2", Persion.class);
        System.out.println(persion);
    }
}
