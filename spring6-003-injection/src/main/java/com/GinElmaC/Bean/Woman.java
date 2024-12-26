package com.GinElmaC.Bean;

public class Woman {
    private String name;

    public Woman() {
    }

    public Woman(String name) {
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
        return "Woman{name = " + name + "}";
    }
}
