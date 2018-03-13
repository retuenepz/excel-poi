package com.hongyb.excel.annotation;


import com.hongyb.excel.style.DefaultCellStyle;
import com.hongyb.excel.style.DefaultMenuStyle;
import com.hongyb.excel.style.DefaultTitleStyle;
import com.hongyb.excel.style.ExcelStyle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  用来自定义样式的注解
 * 作者:hongyanbo
 * 时间:2018/3/12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Style {
    Class<? extends ExcelStyle> titleStyle() default DefaultTitleStyle.class ;
    Class<? extends ExcelStyle> cellStyle() default DefaultCellStyle.class ;
    Class<? extends ExcelStyle> menuStyle() default DefaultMenuStyle.class ;

}
