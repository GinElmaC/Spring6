工厂方法模式

1.工厂方法模式可以解决简单工厂模式当中的OCP问题
    怎么解决？一个工厂对应生产一个产品，这样工厂就不是全能累了，另外也可以符合OCP开闭原则

2.工厂方法模式中的角色：
    *抽象产品角色 Weapon
    *具体产品角色 Dagger Gun
    *抽象工厂角色 WeaponFactory
    *具体工厂角色 DaggerFactory GunFactory

3.工厂方法模式的优点
    当你扩展一个产品的时候符合OCP原则，因为只需要添加两个类，一个是具体工厂角色，一个是具体产品类。都是添加类，没有修改原先的代码，符合OCP原则

4.工厂方法模式的缺点
    每次拓展一个产品时，都需要增加一个具体工厂类和具体对象类，使得系统中类的个数增加
    在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖，这不是好情况。