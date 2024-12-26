package com.GinElmaC.client;

import com.GinElmaC.annotation.Compent;

public class test {
    //通过反射机制读取注解
    public static void main(String[] args) throws ClassNotFoundException {
        //获取类
        Class<?> aClass = Class.forName("com.GinElmaC.Bean.User");
        //判断这个类上面有没有这个注解
        if(aClass.isAnnotationPresent(Compent.class)){
            //如果有，获取类上的注解
            Compent compent = aClass.getAnnotation(Compent.class);
            //访问注解属性
            System.out.println(compent.name());
        }


    }
}
