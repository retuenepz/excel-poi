package com.hongyb.excel;


import com.hongyb.excel.builder.ExcelWriterBuilder;
import com.hongyb.excel.core.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * API
 *
 * 作者:hongyanbo
 * 时间:2018/3/15
 */
public class BITME {

    public static ExcelWriterBuilder builder(File file){
        return new ExcelWriterBuilder(file);
    }

    public static <T> List<T> read(File file,Class<T> type){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            return read(fileInputStream,type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T> List<T> read(InputStream inputStream,Class<T> type){
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            return new ExcelReader<T>().read(workbook, type);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

}
