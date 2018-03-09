package com.hongyb.excel.utils;

/**
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class StringUtils {

    public static boolean isNotBlank(String s ){
        if(s != null && !s.equals("")){
            return true ;
        }
        return false;
    }
}
