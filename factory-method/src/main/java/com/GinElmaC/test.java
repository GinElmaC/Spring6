package com.GinElmaC;

/**
 * 客户端程序
 */
public class test {
    public static void main(String[] args) {
        WeaponFactory weaponFactory1 = new DaggerFactory();
        Dagger dagger = (Dagger) weaponFactory1.get();
        dagger.attack();
        WeaponFactory weaponFactory2 = new GunFactory();
        Gun gun = (Gun)weaponFactory2.get();
        gun.attack();
    }
}
