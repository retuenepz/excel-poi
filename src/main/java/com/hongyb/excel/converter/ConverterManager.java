package com.hongyb.excel.converter;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class ConverterManager {

  private static Map<Class,Converter> cache = new HashMap<>();

    public static Converter getConverter(Class clazz){
        if(cache.containsKey(clazz)){
            return cache.get(clazz);
        }else{
            // new converter
            try {
                Converter converter = (Converter) clazz.newInstance();
                cache.put(clazz,converter);
                return converter;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
