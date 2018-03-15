package com.hongyn.excel;

import com.hongyb.excel.builder.ExcelWriterBuilder;
import com.hongyb.excel.utils.ExcelType;
import com.hongyn.excel.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class Main {

    private List<Student> dataList = new ArrayList<>();
    @Before
    public void data(){
        Student xiaoming = new Student();
        xiaoming.setId("001");
        xiaoming.setName("小明");
        xiaoming.setAge(18);
        xiaoming.setBirth(new Date());
        Student xiaohong = new Student();
        xiaohong.setId("002");
        xiaohong.setName("小红");
        xiaohong.setAge(18);
        xiaohong.setGender("0");
        xiaohong.setBirth(new Date());
        dataList.add(xiaoming);
        dataList.add(xiaohong);
    }
    @Test
    public void test01() throws IOException {
        File file = new File("xxx.xlsx");
        ExcelWriterBuilder builder = new ExcelWriterBuilder(file);
        builder.title("测试哟").sheetName("shit").list(dataList).build(Student.class).write();
    }

}
