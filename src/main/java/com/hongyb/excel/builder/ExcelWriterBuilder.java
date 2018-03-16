package com.hongyb.excel.builder;

import com.hongyb.excel.annotation.Style;
import com.hongyb.excel.style.DefaultStyle;
import com.hongyb.excel.style.StyleManager;
import com.hongyb.excel.utils.ExcelType;
import com.hongyb.excel.core.ExcelWriter;
import com.hongyb.excel.utils.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public class ExcelWriterBuilder {
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
    Workbook workbook = null;
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

    private File file ;

    private OutputStream outputStream ;
    private ExcelWriter  writer= null ;
    public ExcelWriterBuilder(File file) {
        this.file = file ;
        if(file != null ){
            String name = file.getName();
            if(StringUtils.isNotBlank(name)){
                if(name.endsWith(".xls")){
                    this.workbook = new HSSFWorkbook();
                }else if(name.endsWith(".xlsx")){
                    this.workbook = new XSSFWorkbook();
                }else{
                    throw new IllegalArgumentException("不支持的文件类型");
                }
            }
        }
        this.styleManager = new StyleManager(workbook);
    }
    public ExcelWriterBuilder title(String title){
        this.titleName = title ;
        return this;
    }
    public ExcelWriterBuilder sheetName(String sheetName){
        this.sheetName = sheetName ;
        return this ;
    }
    public ExcelWriterBuilder titleStyle(CellStyle style){
        this.titleStyle = style ;
        return this;
    }
    public ExcelWriterBuilder cellStyle(CellStyle style){
        this.cellStyle = style ;
        return this;
    }
    public ExcelWriterBuilder menuStyle(CellStyle style){
        this.menuStyle = style;
        return this;
    }
    public ExcelWriterBuilder list(List<?> list){
        this.dataList = list ;
        return this;
    }

    public ExcelWriterBuilder build(Class<?> clazz){
        resolveStyle(clazz);

        this.writer = new ExcelWriter(sheetName,titleName,dataList,workbook,titleStyle,cellStyle,menuStyle);
        return this;
    }

    public void write() throws IOException {
        this.writer.write(file);
    }
    public void response(HttpServletResponse response) throws IOException {
        response.setContentType("application/x-xls");
        String fileName = new String(file.getName().getBytes("UTF-8"),"ISO8859-1");
        response.setHeader("Content-Disposition","attachment; filename="+fileName);
        this.writer.write(response.getOutputStream());
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
            this.cellStyle = DefaultStyle.cellStyle(this.workbook);
            this.menuStyle = DefaultStyle.menuStyle(this.workbook);
            this.titleStyle = DefaultStyle.titleStyle(this.workbook);
        }
    }


}
