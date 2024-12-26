package com.GinElmaC.proxy.service;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimerInvocationHandler implements InvocationHandler {
    private OrderService orderService;
    public TimerInvocationHandler(Object orderService){
        this.orderService = (OrderService) orderService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object re = method.invoke(orderService,args);
        long end = System.currentTimeMillis();
        long time = end-start;
        System.out.println("耗时："+time);
        return re;
    }
}
