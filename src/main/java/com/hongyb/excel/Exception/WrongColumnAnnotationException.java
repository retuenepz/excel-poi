package com.hongyb.excel.Exception;

/**
 * {@link com.hongyb.excel.annotation.Column} 注解使用错误
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class WrongColumnAnnotationException extends RuntimeException{
    public WrongColumnAnnotationException(String message) {
        super(message);
    }
}
