package com.hongyn.excel.converter;

import com.hongyb.excel.converter.Converter;
import com.hongyb.excel.utils.StringUtils;
import org.apache.poi.ss.usermodel.Cell;

import java.lang.reflect.Field;

/**
 * 作者:hongyanbo
 * 时间:2018/3/14
 */
public class GenderConverter implements Converter<String> {
    @Override
    public String convert(String value) {
        if("0".equals(value)){
            return "女";
        }else{
            return "男";
        }
    }
    @Override
    public String from(Cell cell, Field field) {
        String val = cell.getStringCellValue();
        if(StringUtils.isNotBlank(val)){
            if(val.equals("男")){
                return "1";
            }else{
                return "0";
            }
        }
        return "";
    }
}
