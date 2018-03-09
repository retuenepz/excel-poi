package com.hongyn.excel.model;

import com.hongyb.excel.annotation.Column;

/**
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class Student {
    @Column(0)
    private String name ;
    @Column(1)
    private int age ;
    @Column(2)
    private String id ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
