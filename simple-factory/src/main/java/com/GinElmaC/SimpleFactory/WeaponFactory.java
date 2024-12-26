package com.GinElmaC.SimpleFactory;

/**
 * 工厂类角色
 */
public class WeaponFactory {
    /**
     * 静态方法，要获取什么产品，就传入什么参数
     * @param weaponType
     * @return
     */
    public static Weapon get(String weaponType){
        if("tank".equalsIgnoreCase(weaponType)){
            return new tank();
        }else if("dagger".equalsIgnoreCase(weaponType)){
            return new Dagger();
        }else if("fither".equalsIgnoreCase(weaponType)){
            return new Fither();
        }
        return null;
    }
}
