 package com.hongyb.excel.converter;

import com.hongyb.excel.Exception.FieldTypeNotSupportedException;
import com.hongyb.excel.utils.DateUtils;
import org.apache.poi.ss.usermodel.Cell;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class BasicConverter implements Converter {
    @Override
    public String convert(Object value) {
        if(value == null){
            return "";
        }
        // 只有Date要特殊处理，其他都可以直接转化。
        if(value instanceof Date){
            return DateUtils.format((Date) value,"yyyy-MM-dd");
        }
        return value.toString();
    }

    @Override
    public Object from(Cell cell, Field field) {
        Class type = field.getType();
        if(int.class == type || Integer.class == type){
            return Integer.parseInt(cell.getStringCellValue());
        }else if(float.class == type || Float.class == type){
            return Float.parseFloat(cell.getStringCellValue());
        }else if(double.class == type || Double.class==type){
            return cell.getNumericCellValue();
        }else if(String.class == type){
            return cell.getStringCellValue();
        }else if(Date.class == type){
            return cell.getDateCellValue();
        }else{
            throw new FieldTypeNotSupportedException("不支持的属性类型，需要自定义converter");
        }
    }


}
