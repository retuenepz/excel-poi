package com.hongyb.excel.style;

import com.sun.xml.internal.bind.v2.TODO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

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
    public static CellStyle titleStyle(HSSFWorkbook workbook){
        if(titleStyle!=null){
            return titleStyle;
        }
        titleStyle = workbook.createCellStyle() ;
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
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
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyle;

    }

    public static CellStyle menuStyle(HSSFWorkbook hssfWorkbook) {
        if(menuStyle!= null){
            return menuStyle;
        }
        menuStyle = hssfWorkbook.createCellStyle();

        menuStyle.setAlignment(HorizontalAlignment.CENTER);
        menuStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        return menuStyle;
    }
}
