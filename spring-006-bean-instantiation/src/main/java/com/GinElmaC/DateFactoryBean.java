package com.GinElmaC;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFactoryBean implements FactoryBean<Date> {
    private String date;

    public DateFactoryBean() {
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date datenow = sdf.parse(date);
        return datenow;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    /**
     * 获取
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        return "DateFactoryBean{date = " + date + "}";
    }
}
