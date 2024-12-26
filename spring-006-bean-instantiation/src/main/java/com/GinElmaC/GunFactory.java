package com.GinElmaC;

/**
 * 具体工厂角色
 */
public class GunFactory {
    public GunFactory(){
        System.out.println("GunFactory无参构造方法");
    }
    public Gun getGun(){
        return new Gun();
    }
}
