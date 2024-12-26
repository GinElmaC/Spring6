package com.GinElmaC.Bean;

public class Class {
    private String name;

    public Class() {
    }

    public Class(String name) {
        this.name = name;
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

    public String toString() {
        return "Class{name = " + name + "}";
    }
}
