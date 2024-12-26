package com.GinElmaC;

public class StarFactory {

    public StarFactory(){
        System.out.println("starFactory的无参构造方法执行");
    }

    public static Star get(){
        return new Star();
    }
}
