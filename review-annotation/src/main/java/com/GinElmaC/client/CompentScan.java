package com.GinElmaC.client;

import com.GinElmaC.annotation.Compent;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CompentScan {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        String pack = "com.GinElmaC.Bean";
        //"."在正则表达式中代表任意字符，这里的“.”必须是普通的字符
        //用\.即可表达一个正常的.，但在java语法中要用\\代表\
        //获取报的目录
        String packPath = pack.replaceAll("\\.","/");
        //com在类的根路径下，所以我们可以用ClassLoader，因为这个默认是从类的根路径下加载资源
        URL resource = ClassLoader.getSystemClassLoader().getResource(packPath);
        String path = resource.getPath();
        //获取绝对路径下的所有文件
        File file = new File(path);
        File[] files = file.listFiles();
        Arrays.stream(files).forEach(f->{
            try {
                String str = f.getName().split("\\.")[0];
                Class<?> clazz = Class.forName(pack+ "."+ str);
                if(clazz.isAnnotationPresent(Compent.class)){
                    Compent compent = clazz.getAnnotation(Compent.class);
                    String com = compent.name();
                    Object obj = clazz.newInstance();
                    map.put(com,obj);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(map.toString());
    }
}
