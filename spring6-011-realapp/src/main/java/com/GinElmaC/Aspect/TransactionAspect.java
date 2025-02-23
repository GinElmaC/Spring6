package com.GinElmaC.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAspect {
    @Around("execution(public * com.GinElmaC.Service..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint){
        //执行目标
        try {
            //前环绕
            System.out.println("开启事务");
            joinPoint.proceed();
            //后环绕
            System.out.println("提交事务");
        } catch (Throwable e) {
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }
}
