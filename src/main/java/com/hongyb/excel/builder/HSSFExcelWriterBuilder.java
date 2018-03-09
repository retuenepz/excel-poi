package com.hongyb.excel.builder;

import com.hongyb.excel.ExcelWriter;
import com.hongyb.excel.style.DefaultStyle;
import com.hongyb.excel.utils.Collections;
import com.hongyb.excel.utils.StringUtils;
import com.hongyb.excel.writer.HSSFExcelWriter;
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

    public HSSFExcelWriterBuilder(HSSFWorkbook hssfWorkbook) {
        this.hssfWorkbook = hssfWorkbook;
    }

    public HSSFExcelWriterBuilder() {
        this.hssfWorkbook = new HSSFWorkbook();
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
    public HSSFExcelWriterBuilder list(List<?> list){
        this.dataList = list ;
        return this;
    }

    public ExcelWriter build(){
        // 设置默认的样式
        if(StringUtils.isNotBlank(titleName) && titleStyle == null){
            titleStyle = DefaultStyle.titleStyle(hssfWorkbook);
        }
        if(Collections.isNotBlank(dataList) && cellStyle == null ){
            cellStyle = DefaultStyle.cellStyle(hssfWorkbook) ;
        }
        return new HSSFExcelWriter(sheetName,titleName,dataList,hssfWorkbook,titleStyle,cellStyle);
    }


}
