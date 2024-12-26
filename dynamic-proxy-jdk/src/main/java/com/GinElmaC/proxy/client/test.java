package com.GinElmaC.proxy.client;

import com.GinElmaC.proxy.Util.ProxyUtil;
import com.GinElmaC.proxy.service.OrderService;
import com.GinElmaC.proxy.service.OrderServiceImpl;
import com.GinElmaC.proxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
//        OrderService pro = (OrderService)Proxy.newProxyInstance(orderService.getClass().getClassLoader(),
//                                            orderService.getClass().getInterfaces(),
//                                            new TimerInvocationHandler(orderService));
        OrderService pro1 = (OrderService)ProxyUtil.newProxyInstance(orderService);
        pro1.insert();
        pro1.modity();
        pro1.delect();
        String name = pro1.getName();
        System.out.println(name);
    }
}
