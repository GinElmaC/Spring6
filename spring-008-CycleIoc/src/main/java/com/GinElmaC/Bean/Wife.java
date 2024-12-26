package com.GinElmaC.Bean;

public class Wife {
    private String name;
    private HusBand husBand;

    public Wife() {
    }

    public Wife(String name, HusBand husBand) {
        this.name = name;
        this.husBand = husBand;
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
     * @return husBand
     */
    public HusBand getHusBand() {
        return husBand;
    }

    /**
     * 设置
     * @param husBand
     */
    public void setHusBand(HusBand husBand) {
        this.husBand = husBand;
    }

    public String toString() {
        return "Wife{name = " + name + ", husBand = " + husBand.getName() + "}";
    }
}
