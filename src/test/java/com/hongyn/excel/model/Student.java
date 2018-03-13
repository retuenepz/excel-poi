package com.hongyn.excel.model;

import com.hongyb.excel.annotation.Column;
import com.hongyb.excel.annotation.Style;
import com.hongyn.excel.style.YelloStyle;

import java.util.Date;

/**
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
@Style(titleStyle = YelloStyle.class ,menuStyle = YelloStyle.class)
public class Student {
    @Column(value=1,menu = "姓名")
    private String name ;
    @Column(value=2,menu = "年龄")
    private int age ;
    @Column(value=0,menu = "id")
    private String id ;
    @Column(value=3,menu ="出生日期")
    private Date birth ;

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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
