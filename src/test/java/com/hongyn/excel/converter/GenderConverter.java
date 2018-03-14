package com.hongyn.excel.converter;

import com.hongyb.excel.converter.Converter;

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
    public String from(String s) {
        return null;
    }
}
