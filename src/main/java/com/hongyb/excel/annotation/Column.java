package com.hongyb.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    /**
     *  代表该属性位于第几列，从0开始 -1就错了。
     * @return
     */
    int value() default -1 ;


}
