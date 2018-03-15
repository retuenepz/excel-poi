 package com.hongyb.excel.converter;

import com.hongyb.excel.Exception.FieldTypeNotSupportedException;
import com.hongyb.excel.utils.DateUtils;
import com.hongyb.excel.utils.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class BasicConverter implements Converter {
    @Override
    public String convert(Object value) {
        if(value == null){
            return "";
        }
        // 只有Date要特殊处理，其他都可以直接转化。
        if(value instanceof Date){
            return DateUtils.format((Date) value,"yyyy-MM-dd");
        }
        return value.toString();
    }

    @Override
    public Object from(Cell cell, Field field) {

        Class type = field.getType();
        String value = getStringValueOfCell(cell);
        if(StringUtils.isNotBlank(value)) {
            if (int.class == type || Integer.class == type) {
                return Integer.parseInt(value);
            } else if (float.class == type || Float.class == type) {
                return Float.parseFloat(value);
            } else if (double.class == type || Double.class == type) {
                return Double.parseDouble(value);
            } else if (String.class == type) {
                return value;
            } else if (Date.class == type) {
                return DateUtils.parse(value);
            } else {
                throw new FieldTypeNotSupportedException("不支持的属性类型，需要自定义converter");
            }
        }
        return null ;
    }

    private String getStringValueOfCell(Cell cell){
        switch (cell.getCellTypeEnum()) {
            case STRING:
                return cell.getRichStringCellValue().getString();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return DateUtils.format(cell.getDateCellValue());
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return cell.getBooleanCellValue()?"true":"false";
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return null;
            default:
                return null;
        }
    }

}
