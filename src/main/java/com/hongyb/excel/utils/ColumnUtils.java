package com.hongyb.excel.utils;

import com.hongyb.excel.Exception.WrongColumnAnnotationException;
import com.hongyb.excel.annotation.Column;
import com.hongyb.excel.converter.Converter;

import java.lang.reflect.Field;

/**
 * 注解{@link com.hongyb.excel.annotation.Column}操作类
 * 作者:hongyanbo
 * 时间:2018/3/12
 */
public class ColumnUtils {
    public static int getOrder(Field field ){
        Column columnAnno = field.getAnnotation(Column.class);
        if (columnAnno==null || columnAnno.value() == -1) {
            throw new WrongColumnAnnotationException("实体类 @Column.value 未定义");
        }
        return columnAnno.value();
    }

    public static String getMenu(Field field) {
        Column menu = field.getAnnotation(Column.class);
        if(menu ==null || StringUtils.isBlank(menu.menu())){
            throw new WrongColumnAnnotationException("实体类 @Column.menu 未定义");
        }
        return menu.menu();
    }

    public static Class<? extends Converter> getConverter(Field field){
        Column annotation = field.getAnnotation(Column.class);
        if(annotation == null || annotation.converter() ==null){
            throw new WrongColumnAnnotationException("实体类 @Column 未定义");
        }
        return annotation.converter();
    }
}
