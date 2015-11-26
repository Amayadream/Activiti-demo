package com.amayadream.demo.util;

import java.util.Date;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.util
 * Author :  Amayadream
 * Date   :  2015.11.26 14:07
 * TODO   :  属性数据类型
 */
public enum PropertyType {
    S(String.class), I(Integer.class), L(Long.class), F(Float.class), N(Double.class), D(Date.class), SD(java.sql.Date.class), B(
    Boolean.class);

    private Class<?> clazz;

    private PropertyType(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getValue() {
        return clazz;
    }
}
