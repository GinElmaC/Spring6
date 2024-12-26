package com.GinElmaC.Bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component("A")
public class A {
    public A(){
        System.out.println("A的无参构造");
    }
}
@Controller("B")
class B{
    public B(){
        System.out.println("B的无参构造");
    }
}
@Service("C")
class C{
    public C(){
        System.out.println("C的无参构造");
    }
}
@Repository("D")
class D{
    public D(){
        System.out.println("D的无参构造");
    }
}
