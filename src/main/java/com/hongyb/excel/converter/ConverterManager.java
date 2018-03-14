package com.hongyb.excel.converter;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * TODO 打算设计成converter的缓存，减少对象的创建。
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class ConverterManager {
  private static Map<String,Converter> cache = new HashMap<>();
    public static Converter getConverter(Class<? extends Converter> clazz){
        if(cache.containsKey(clazz.getName())){
            return cache.get(clazz.getName());
        }else{
            // new converter
            try {
                Converter converter = clazz.newInstance();
                cache.put(clazz.getName(),converter);
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
