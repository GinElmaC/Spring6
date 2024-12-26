package com.GinElmaC.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//切面是需要@Aspect注解标注的
@Aspect
@Order(2)
public class LogAspect {//切面
    //通用切点
    //这个注解定义通用的切点表达式
    @Pointcut("execution(public * com.GinElmaC.service..*(..))")
    public void 通用切点(){
        //这个方法只是一个标记，方法名随意，方法体也不需要
    }
    //切面=通知+切点
    //通知，通知就是增强，就是具体增强的代码
    //before注解意思就是前置通知，括号里添加切点表达式
    @Before("通用切点()")
    public void 前置增强(){
        System.out.println("前置增强");
    }
    @AfterReturning("通用切点()")
    public void 后置增强(){
        System.out.println("后置增强");
    }

    @Around("通用切点()")
    public void 环绕通知(ProceedingJoinPoint joinPoint) throws Throwable {
        //前环绕
        System.out.println("前环绕");
        //这行代码主要是用来执行目标的
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("捕捉到异常");
        }
        //后环绕
        System.out.println("后环绕");
    }
    //最终通知（finally语句块中的通知）
    @After("通用切点()")
    public void 最终通知(){
        System.out.println("最终通知");
    }
    //异常通知
    @AfterThrowing("通用切点()")
    public void 异常通知(){
        System.out.println("异常通知");
    }
    //切点
}
