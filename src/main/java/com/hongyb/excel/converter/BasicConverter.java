 package com.hongyb.excel.converter;

import com.hongyb.excel.utils.DateUtils;

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
    public Object from(String s) {
        // TODO 这里的设计好像有问题!!!!
        return null;
    }
}
