package com.hongyb.excel.core;

import com.hongyb.excel.annotation.StartRow;
import com.hongyb.excel.converter.Converter;
import com.hongyb.excel.converter.ConverterManager;
import com.hongyb.excel.utils.ColumnUtils;
import org.apache.poi.ss.usermodel.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者:hongyanbo
 * 时间:2018/3/14
 */
public class ExcelReader <T> {
    public  List<T> read(Workbook workbook ,Class<T> clazz){
        List<T> result = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0); //只读第一个sheet
        int startRow = 0 ; //从第几行开始读
        startRow = getStartRow(clazz);
        for(int i = startRow ; i < sheet.getLastRowNum(); i ++){
            Row row = sheet.getRow(i);
            T t = assembleObject(clazz, row);
            result.add(t);
        }
        return result ;
    }

    /**
     * 装配对象
     * @param clazz
     * @param row
     */
    private T assembleObject(Class<T> clazz, Row row) {
        try {
            T t = clazz.newInstance();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                int order = ColumnUtils.getOrder(field);
                Cell cell = row.getCell(order);
                field.set(t,getCellValue(cell,field));
            }
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 用converter来处理cell value
     * @param cell
     * @return
     */
    private Object getCellValue(Cell cell,Field field) {
        Class<? extends Converter> converterClass = ColumnUtils.getConverter(field);

        Converter converter = ConverterManager.getConverter(converterClass);
        Object val = converter.from(cell, field);
        return val ;
    }

    /**
     * 获取注解@startRow的值
     * @param clazz
     * @param <T>
     * @return
     */
    private <T> int getStartRow(Class<T> clazz) {
        StartRow s = clazz.getAnnotation(StartRow.class);
        if(s!=null){
            return s.value();
        }
        return 0;
    }
}
