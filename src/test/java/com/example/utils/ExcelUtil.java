package com.example.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    private Workbook workbook;

    public ExcelUtil(String filePath) {
        try {
        	filePath= System.getProperty("user.dir")+"/src/test/resources/testdata";
            workbook = WorkbookFactory.create(new FileInputStream(filePath));
        } catch (Exception e) {
            throw new RuntimeException("Failed to open Excel file: " + filePath, e);
        }
    }

    public Object[][] getData(String sheetName) {
        Sheet sheet = workbook.getSheet("LoginData");
        if (sheet == null) throw new RuntimeException("Sheet '" + sheetName + "' not found");

        int rows = sheet.getLastRowNum(); // 0-based
        int cols = sheet.getRow(0).getLastCellNum();

        List<Object[]> data = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;
            Object[] arr = new Object[cols];
            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                arr[j] = cell.toString().trim();
            }
            data.add(arr);
        }
        return data.toArray(new Object[0][]);
    }

    public void close() {
        if (workbook != null) {
            try {
                workbook.close();
            } catch (IOException ignored) {
            }
        }
    }
}
