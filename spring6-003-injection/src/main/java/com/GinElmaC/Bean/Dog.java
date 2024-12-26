package com.GinElmaC.Bean;

import java.util.Date;

public class Dog {
    private String name;
    private Date birth;
    private int age;

    public Dog() {
    }

    public Dog(String name, Date birth, int age) {
        this.name = name;
        this.birth = birth;
        this.age = age;
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

    /**
     * 获取
     * @return birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 设置
     * @param birth
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Dog{name = " + name + ", birth = " + birth + ", age = " + age + "}";
    }
}
