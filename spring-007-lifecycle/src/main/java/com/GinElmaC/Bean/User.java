package com.GinElmaC.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean,DisposableBean {
    private String name;
    public User(){
        System.out.println("第一步User的无参构造执行");
    }

    public User(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        System.out.println("第二步User的set方法执行");
        this.name = name;
    }

    public String toString() {
        return "User{name = " + name + "}";
    }
    public void initBean(){
        System.out.println("第四步的initBean");
    }
    public void destoryBean(){
        System.out.println("第七步销毁Bean");
    }

    /**
     * 以下方法会在Bean的后处理器before执行之前执行，可以根据传入的参数进行相应的逻辑处理，可以对Bean进行处理
     */

    /**
     * 根据这个Bean的类加载器进行逻辑处理
     * @param classLoader
     */
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Aware");
    }

    /**
     * 根据这个Bean的Bean工厂进行逻辑处理
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Aware");
    }

    /**
     * 根据这个Bean的名字进行相应逻辑处理
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("Aware");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitalzingBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean");
    }
}
