package com.GinElmaC.Bean;

import java.util.Arrays;

public class Student {
    private String name;
    private Class ct;
    private String[] aihao;
    private Woman[] women;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Class ct, String[] aihao) {
        this.name = name;
        this.ct = ct;
        this.aihao = aihao;
    }

    public Student(String name, Class ct, String[] aihao, Woman[] women) {
        this.name = name;
        this.ct = ct;
        this.aihao = aihao;
        this.women = women;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    public void setCt(Class ct){
        this.ct = ct;
    }
    public Class getCt(){
        return this.ct;
    }



    /**
     * 获取
     * @return aihao
     */
    public String[] getAihao() {
        return aihao;
    }

    /**
     * 设置
     * @param aihao
     */
    public void setAihao(String[] aihao) {
        this.aihao = aihao;
    }

    public String toString() {
        String str = "";
        for(Woman w:women){
            str+=w.getName();
        }
        return "Student{name = " + name + ", ct = " + ct + ", aihao = " + Arrays.toString(aihao) + str + "}";
    }

    /**
     * 获取
     * @return women
     */
    public Woman[] getWomen() {
        return women;
    }

    /**
     * 设置
     * @param women
     */
    public void setWomen(Woman[] women) {
        this.women = women;
    }
}
