package com.text_extraction;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelExtractor {

    public String extractText(File excelFile) {
        StringBuilder result = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(excelFile);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0); 
            for (Row row : sheet) {
                for (Cell cell : row) {
                    result.append(cell.toString()).append(" ");
                }
                result.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
