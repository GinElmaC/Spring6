package com.GinElmaC.SimpleFactory;

/**
 * 具体产品角色
 */
public class tank extends Weapon{
    @Override
    public void attack() {
        System.out.println("坦克开炮");
    }
}
