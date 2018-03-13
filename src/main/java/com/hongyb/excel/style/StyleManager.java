package com.hongyb.excel.style;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 作者:hongyanbo
 * 时间:2018/3/12
 */
public class StyleManager {
    private Workbook workbook = null ;

    public StyleManager(Workbook workbook) {
        this.workbook = workbook;
    }

    public CellStyle getStyle(Class<? extends ExcelStyle> clazz){
        try {
            ExcelStyle excelStyle = clazz.newInstance();
            CellStyle cellStyle = workbook.createCellStyle();
            return excelStyle.setStyle(cellStyle);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
