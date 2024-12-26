import com.GinElmaC.SomeService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class test {
    @Test
    public void testSome() throws Exception{
        /**
         * 调用方法的四要素：
         * 1.谁要调用
         * 2.要调用哪个方法
         * 3.传入什么参数
         * 4.返回什么值
         */

        //获取类
        Class<?> clazz = Class.forName("com.GinElmaC.SomeService");
        //获取方法
        /**
         * 第一个参数：方法名
         * 第二个参数：可变参数，方法的传入参数（因为java语法允许方法名相同的方法重载，所以有这个东西），如果不写传入参数则获取所有名字相同的方法并用Method[]存储
         */
        Method doSome = clazz.getDeclaredMethod("doSome",String.class,int.class);
        /**
         * 调用这个方法
         * 第一个参数：要调用这个方法的对象
         * 第二个参数：要传入什么参数
         */
        SomeService someService = new SomeService();
        Object obj = doSome.invoke(someService, "字符串", 2);
        System.out.println(obj);
    }
}
