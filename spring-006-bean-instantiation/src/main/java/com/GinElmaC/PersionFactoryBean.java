package com.GinElmaC;

import org.springframework.beans.factory.FactoryBean;

public class PersionFactoryBean implements FactoryBean<Persion> {
    public PersionFactoryBean(){
        System.out.println("PersionFactoryBean的无参构造");
    }
    //实现了这个接口的类实际上也是一个bean。只不过这个bean比较特殊，叫做工厂Bean
    //通过工厂bean这个特殊的bean可以获取一个普通的bean
    @Override
    public Persion getObject() throws Exception {
        //最终这个bean返回的还是我们自己new的
        return new Persion();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
    //这个方法在接口中有默认实现
    //默认返回true，表示是单例的
    //如果想多例，直接将这个方法的返回值修改为false
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
