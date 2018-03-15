package com.hongyb.excel.utils;

import java.lang.reflect.Field;

/**
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class ReflectUtil {

    /**
     * 获取属性值
     * @param obj
     * @param field
     * @return
     */
    public static Object getValueOfField(Object obj , Field field){
        field.setAccessible(true);
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null ;
    }
}
