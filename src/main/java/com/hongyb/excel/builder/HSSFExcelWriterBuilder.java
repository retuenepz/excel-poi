package com.hongyb.excel.builder;

import com.hongyb.excel.ExcelWriter;
import com.hongyb.excel.Exception.BuildException;
import com.hongyb.excel.annotation.Style;
import com.hongyb.excel.style.DefaultStyle;
import com.hongyb.excel.style.ExcelStyle;
import com.hongyb.excel.style.StyleManager;
import com.hongyb.excel.utils.Collections;
import com.hongyb.excel.utils.StringUtils;
import com.hongyb.excel.writer.HSSFExcelWriter;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

import java.util.List;

/**
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class HSSFExcelWriterBuilder {
    /**
     * default sheet name
     * 默认的sheet名称
     */
    private String sheetName = "newSheet" ;
    /**
     * 标题名称
     */
    private String titleName = null ;
    /**
     * 数据列表
     */
    List<?> dataList = null;
    /**
     *  workbook
     */
    HSSFWorkbook hssfWorkbook = null;
    /**
     * 标题样式
     */
    CellStyle titleStyle = null ;
    /**
     *  数据格样式
     */
    CellStyle cellStyle = null ;
    /**
     * 菜单style
     */
    private CellStyle menuStyle;

    private StyleManager styleManager = null;
    public HSSFExcelWriterBuilder(HSSFWorkbook hssfWorkbook) {
        this.hssfWorkbook = hssfWorkbook;
    }

    public HSSFExcelWriterBuilder() {
        this.hssfWorkbook = new HSSFWorkbook();
        this.styleManager = new StyleManager(hssfWorkbook);
    }

    public HSSFExcelWriterBuilder title(String title){
        this.titleName = title ;
        return this;
    }
    public HSSFExcelWriterBuilder sheetName(String sheetName){
        this.sheetName = sheetName ;
        return this ;
    }
    public HSSFExcelWriterBuilder titleStyle(CellStyle style){
        this.titleStyle = style ;
        return this;
    }
    public HSSFExcelWriterBuilder cellStyle(CellStyle style){
        this.cellStyle = style ;
        return this;
    }
    public HSSFExcelWriterBuilder menuStyle(CellStyle style){
        this.menuStyle = style;
        return this;
    }
    public HSSFExcelWriterBuilder list(List<?> list){
        this.dataList = list ;
        return this;
    }

    public ExcelWriter build(Class<?> clazz){
        resolveStyle(clazz);

        return new HSSFExcelWriter(sheetName,titleName,dataList,hssfWorkbook,titleStyle,cellStyle,menuStyle);
    }

    /**
     * 处理style注解
     * @param clazz
     */
    private void resolveStyle(Class<?> clazz) {
        Style style = clazz.getAnnotation(Style.class);
        if(style!=null){
            // 应用用户定义样式
            this.cellStyle = styleManager.getStyle(style.cellStyle());
            this.menuStyle = styleManager.getStyle(style.menuStyle());
            this.titleStyle = styleManager.getStyle(style.titleStyle());
        }else{
            this.cellStyle = DefaultStyle.cellStyle(this.hssfWorkbook);
            this.menuStyle = DefaultStyle.menuStyle(this.hssfWorkbook);
            this.titleStyle = DefaultStyle.titleStyle(this.hssfWorkbook);
        }
    }


}
