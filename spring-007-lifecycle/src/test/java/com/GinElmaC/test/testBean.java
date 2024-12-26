package com.GinElmaC.test;

import com.GinElmaC.Bean.Persion;
import com.GinElmaC.Bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testBean {
    @Test
    public void testBeanFive(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("UserBean",User.class);
        System.out.println("第六步使用Bean");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) applicationContext;
        classPathXmlApplicationContext.close();
    }

    /**
     * 测试将自己new的对象纳入spring容器管理。半路上交给spring容器管理
     */
    @Test
    public void testMyNew(){
        //自己new
        Persion persion = new Persion();
        System.out.println("persion:"+persion);
        Persion persino1 = new Persion();
        System.out.println("persion1:"+persino1);

        //交付
        //创建一个默认可列表的工厂，以后在这个工厂内注册和获取Bean
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //注册Bean
        //两个参数：第一个是要注册的Bean的id。第二个是要给谁注册
        defaultListableBeanFactory.registerSingleton("persionBean",persion);
        defaultListableBeanFactory.registerSingleton("persionBean1",persino1);
        Persion p1 = defaultListableBeanFactory.getBean("persionBean", Persion.class);
        System.out.println("persion:"+p1);
        //默认注册后是singleton模式，单例,一个注册的BeanId对应一个实例
        Persion p2 = defaultListableBeanFactory.getBean("persionBean1", Persion.class);
        System.out.println("persion1"+p2);
    }
}
