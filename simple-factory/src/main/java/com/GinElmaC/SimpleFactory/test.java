package com.GinElmaC.SimpleFactory;

/**
 * 客户端程序
 */
public class test {
    public static void main(String[] args) {
        //tank
        tank tank1 = (tank) WeaponFactory.get("tank");
        tank1.attack();
        //dagger
        Dagger dagger = (Dagger)WeaponFactory.get("dagger");
        dagger.attack();
        //fither
        Fither fither = (Fither) WeaponFactory.get("fither");
        fither.attack();
    }
}
