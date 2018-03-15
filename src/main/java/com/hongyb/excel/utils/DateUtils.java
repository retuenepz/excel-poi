package com.hongyb.excel.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class DateUtils {
    public static String format(Date date,String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static String format(Date date){
        return format(date,"yyyy-MM-dd");
    }

    public static Date parse(String value,String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null ;
    }
    public static Date parse(String value){
        return parse(value,"yyyy-MM-dd");
    }
}
