package com.hongyb.excel.utils;

/**
 * 作者:hongyanbo
 * 时间:2018/3/12
 */
public class Arrays {
    public static boolean isNotBlank(Object[] objects){
        if(objects != null && objects.length>0){
            return true;
        }
        return false;
    }
}
