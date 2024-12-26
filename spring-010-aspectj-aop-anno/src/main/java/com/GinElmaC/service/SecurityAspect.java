package com.GinElmaC.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class SecurityAspect {//安全切面
    //通知+切点
    @Before("com.GinElmaC.service.LogAspect.通用切点()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("前置通知：安全");
        //这个方法可以获取目标方法的签名
        Signature signature = joinPoint.getSignature();
        //通过方法名可以获取一个方法的具体信息
        //获取方法的方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName);
    }
}
