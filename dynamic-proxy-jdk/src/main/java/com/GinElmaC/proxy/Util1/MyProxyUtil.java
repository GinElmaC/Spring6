package com.GinElmaC.proxy.Util1;

import com.GinElmaC.proxy.service1.StudentInhans;

import java.lang.reflect.Proxy;

public class MyProxyUtil {
    private Object obj;
    public MyProxyUtil(){

    }

    public static Object getProxy(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                                      obj.getClass().getInterfaces(),
                                      new StudentInhans(obj));
    }
}
