package com.hongyb.excel.style;

import org.apache.poi.ss.usermodel.*;

/**
 * 默认的Cellstyle
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class DefaultStyle {
    private static CellStyle titleStyle = null ;
    private static CellStyle cellStyle = null ;
    private static CellStyle menuStyle = null ;
    /**
     * 默认标题样式
     * @return
     */
    public static CellStyle titleStyle(Workbook workbook){

        titleStyle = workbook.createCellStyle() ;
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return titleStyle ;
    }

    /**
     *
     * @return
     */
    public static CellStyle cellStyle(Workbook workbook){

        cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyle;

    }

    public static CellStyle menuStyle(Workbook hssfWorkbook) {

        menuStyle = hssfWorkbook.createCellStyle();

        menuStyle.setAlignment(HorizontalAlignment.CENTER);
        menuStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        return menuStyle;
    }
}
