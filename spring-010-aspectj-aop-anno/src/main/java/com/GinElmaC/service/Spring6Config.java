package com.GinElmaC.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//代替spring6配置文件的注解
@Configuration
@ComponentScan({"com.GinElmaC.service"})
//启用AspectJ的自动代理
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Spring6Config {

}
