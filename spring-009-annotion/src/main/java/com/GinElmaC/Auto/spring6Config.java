package com.GinElmaC.Auto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 编写一个类代替spring6的配置文件
 */
//下方注解表示全注解开发
@Configuration
//下方注解代替原配置文件的组件扫描标签
@ComponentScan({"com.GinElmaC.Auto"})
public class spring6Config {
}
