package com.hongyn.excel.style;

import com.hongyb.excel.style.ExcelStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 * 作者:hongyanbo
 * 时间:2018/3/13
 */
public class YelloStyle implements ExcelStyle {
    @Override
    public CellStyle setStyle(CellStyle cellStyle) {
        // MLGB 不是黄色吗 shit
        cellStyle.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
        cellStyle.setFillPattern(FillPatternType.BIG_SPOTS);
        return cellStyle;
    }
}
