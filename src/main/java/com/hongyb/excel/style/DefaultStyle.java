package com.hongyb.excel.style;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 * 默认的Cellstyle
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class DefaultStyle {
    private static CellStyle titleStyle = null ;
    private static CellStyle cellStyle = null ;
    /**
     * 默认标题样式
     * @return
     */
    public static CellStyle titleStyle(HSSFWorkbook workbook){
        if(titleStyle!=null){
            return titleStyle;
        }
        titleStyle = workbook.createCellStyle() ;
        //TODO

        return titleStyle ;
    }

    /**
     *
     * @return
     */
    public static CellStyle cellStyle(HSSFWorkbook workbook){
        if(cellStyle!= null){
            return cellStyle;
        }
        cellStyle = workbook.createCellStyle();
        // TODO
        return cellStyle;

    }

}
