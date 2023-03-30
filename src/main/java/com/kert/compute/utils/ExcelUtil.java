package com.kert.compute.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.apache.poi.ss.usermodel.WorkbookFactory.*;

public class ExcelUtil {
    public static ArrayList<Object> read(InputStream is) throws IOException {
        Workbook sheets = create(is);
        Sheet sheet = sheets.getSheetAt(0);
        ArrayList<Object> ret = new ArrayList<>();
        Row title = sheet.getRow(0);
        for (Row row:sheet){
            HashMap<Object, Object> rowMap = new HashMap<>();
            for(int i=0;i<row.getLastCellNum();i++){
                rowMap.put(title.getCell(i).getStringCellValue(),row.getCell(i).getStringCellValue());
            }
            ret.add(rowMap);
        }
        sheets.close();
        return ret;
    }
}
