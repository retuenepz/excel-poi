package com.hongyb.excel.writer;

import com.hongyb.excel.ExcelWriter;
import com.hongyb.excel.annotation.Column;
import com.hongyb.excel.utils.Collections;
import com.hongyb.excel.utils.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * HSSF  Excel 97-2007
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class HSSFExcelWriter implements ExcelWriter {
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


    public HSSFExcelWriter(String sheetName, String titleName, List<?> dataList, HSSFWorkbook hssfWorkbook, CellStyle titleStyle, CellStyle cellStyle) {
        this.sheetName = sheetName;
        this.titleName = titleName;
        this.dataList = dataList;
        this.hssfWorkbook = hssfWorkbook;
        this.titleStyle = titleStyle;
        this.cellStyle = cellStyle;
    }

    /**
     * 导出excel
     */
    public void write(OutputStream output) throws IOException {

        int startRow = 0 ;
        HSSFSheet sheet = hssfWorkbook.createSheet(sheetName);
        // title处理
        if(StringUtils.isNotBlank(titleName)){
            // 设置标题样式和内容
            HSSFRow titleRow = sheet.createRow(startRow);
            HSSFCell titleCell = titleRow.createCell(0);
            titleCell.setCellStyle(titleStyle);
            titleCell.setCellValue(titleName);
            // 合并多少行 默认5
            int mergeColCount = 5 ;
            if(Collections.isNotBlank(dataList)){
                mergeColCount=dataList.size();
            }
            // 标题单元格合并
            sheet.addMergedRegion(new CellRangeAddress(startRow,0,0,mergeColCount));
            startRow++;
        }
        // 数据list处理
        if(Collections.isNotBlank(dataList)){
            // 循环写
            for (Object o : dataList) {
                HSSFRow row = sheet.createRow(startRow++);
                Field[] fields = o.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    //  TODO 注解实现
                    Field field = fields[i];
                    Column columnAnno = field.getAnnotation(Column.class);
                    if (columnAnno==null) {
                        // TODO 抛异常
                    }
                    HSSFCell cell = row.createCell(i);
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue("123123");
                }
            }

        }
        // 输出文件
        hssfWorkbook.write(output);
        output.close();
    }

    @Override
    public void write(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        write(fileOutputStream);
    }
}
