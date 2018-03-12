package com.hongyb.excel.utils;

import java.util.Collection;
import java.util.List;

/**
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class Collections {

    public static boolean isNotBlank(Collection list){
        if(list != null && list.size()>0){
            return true;
        }
        return false;
    }

    public static boolean isBlank(List<?> dataList) {
        return !isNotBlank(dataList);
    }
}
