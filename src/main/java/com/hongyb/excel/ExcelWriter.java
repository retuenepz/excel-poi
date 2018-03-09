package com.hongyb.excel;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 作者:hongyanbo
 * 时间:2018/3/9
 */
public interface ExcelWriter {
    void write(OutputStream os) throws IOException;
    void write(File file) throws IOException;
}
