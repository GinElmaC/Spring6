package com.GinElmaC.Bean;

import java.util.List;
import java.util.Set;

public class persion {
    private List<String> names;
    private Set<String> addrs;

    public persion() {
    }

    public persion(List<String> names, Set<String> addrs) {
        this.names = names;
        this.addrs = addrs;
    }

    /**
     * 获取
     * @return names
     */
    public List<String> getNames() {
        return names;
    }

    /**
     * 设置
     * @param names
     */
    public void setNames(List<String> names) {
        this.names = names;
    }

    /**
     * 获取
     * @return addrs
     */
    public Set<String> getAddrs() {
        return addrs;
    }

    /**
     * 设置
     * @param addrs
     */
    public void setAddrs(Set<String> addrs) {
        this.addrs = addrs;
    }

    public String toString() {
        return "persion{names = " + names + ", addrs = " + addrs + "}";
    }
}
