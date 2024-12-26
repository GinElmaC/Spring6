package com.GinElmaC.proxy.service1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudentInhans implements InvocationHandler {
    private StudentDao studentDao;
    public StudentInhans(Object object){
        this.studentDao = (StudentDao) object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Stu增强");
        Object re = method.invoke(studentDao,args);
        return re;
    }
}
