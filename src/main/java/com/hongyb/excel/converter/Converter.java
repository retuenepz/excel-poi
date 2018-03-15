package com.hongyb.excel.converter;

import org.apache.poi.ss.usermodel.Cell;

import java.lang.reflect.Field;

/**
 *  String和某种类型的转化接口
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public interface Converter <T>{

    String convert(T value);


    T from(Cell cell , Field field);
}
