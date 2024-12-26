package com.GinElmaC.proxy.Util;

import com.GinElmaC.proxy.service.OrderService;
import com.GinElmaC.proxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyUtil {
    /**
     * 获取代理对象的静态方法
     * @param orderService
     * @return
     */
    public static Object newProxyInstance(Object orderService){
         return Proxy.newProxyInstance(orderService.getClass().getClassLoader(),
                orderService.getClass().getInterfaces(),
                new TimerInvocationHandler(orderService));
    }
}
