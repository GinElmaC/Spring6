package com.GinElmaC.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */

//标注注解的注解叫做元注解。@Target注解用来修饰@Compent可以出现的位置
//下面表示@compent注解可以出现在类上，属性上
//@Target(value = {ElementType.TYPE,ElementType.FIELD})
//下面表示@Compent注解只能出现在类上
//@Target(value = {ElementType.TYPE})
//如果注解的属性名是value的话，value可以省略
//@Target({Element.TYPE})
//如果注解的属性是数组，且只有一个元素，则大括号可省略
//@Target(Element.TYPE)
//@Retention(RetentionPolicy.RUNTIME)表示：如果你想以后反射的时候可以得到注解，就把这个属性加上
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Compent {
    //定义注解的属性
    //String是属性类型
    //value是属性名
    String name();
}
