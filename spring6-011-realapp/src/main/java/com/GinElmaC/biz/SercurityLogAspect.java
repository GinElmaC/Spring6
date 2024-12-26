package com.GinElmaC.biz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component
@Aspect
public class SercurityLogAspect {
    @Pointcut("execution(* com.GinElmaC.biz..insert*(..))")
    public void insert切点(){

    }
    @Pointcut("execution(* com.GinElmaC.biz..delect*(..))")
    public void delect切点(){

    }
    @Pointcut("execution(* com.GinElmaC.biz..motify*(..))")
    public void motify切点(){

    }
    @Pointcut("execution(* com.GinElmaC.biz..select*(..))")
    public void select切点(){

    }
    @Before("insert切点()||delect切点()||motify切点()||select切点()")
    public void beforeAdvice(JoinPoint joinPoint){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowtime = simpleDateFormat.format(new Date());
        System.out.println(nowtime+"张三"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
    }
}
