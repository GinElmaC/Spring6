package com.GinElmaC;


import java.util.Date;

public class Persion {
    public Persion(){
        System.out.println("Persion的无参构造");
    }
    private Date birth;

    public Persion(Date birth) {
        this.birth = birth;
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

    public String toString() {
        return "Persion{birth = " + birth + "}";
    }
}
