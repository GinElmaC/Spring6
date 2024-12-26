package com.GinElmaC.Bean;

public class HusBand {
    private String name;
    private Wife wife;

    public HusBand() {
    }

    public HusBand(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
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
     * @return wife
     */
    public Wife getWife() {
        return wife;
    }

    /**
     * 设置
     * @param wife
     */
    public void setWife(Wife wife) {
        this.wife = wife;
    }

    public String toString() {
        return "HusBand{name = " + name + ", wife = " + wife.getName() + "}";
    }
}
