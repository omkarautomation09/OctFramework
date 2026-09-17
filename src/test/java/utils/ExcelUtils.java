package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    /**
     * Returns every column in the sheet as Object[][], one row per test case.
     * Use this when a test needs multiple columns per row (e.g. login: username + password).
     */
    public static Object[][] getData(String filePath, String sheetName) throws IOException {

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in " + filePath);
            }

            int lastRow = sheet.getLastRowNum();               // 0-indexed row number of the last row with data
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[lastRow][cols];       // lastRow data rows (header excluded)

            for (int i = 1; i <= lastRow; i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    XSSFCell cell = (row == null) ? null : row.getCell(j);
                    data[i - 1][j] = (cell == null) ? "" : cell.toString();
                }
            }

            return data;
        }
    }

    /**
     * Returns ONE named column as Object[n][1] - shaped for a single-String-parameter @DataProvider.
     * Column is matched by header text in row 0 (case-insensitive, trimmed).
     */
    public static Object[][] getColumnData(String filePath, String sheetName, String columnName) throws IOException {

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in " + filePath);
            }

            XSSFRow headerRow = sheet.getRow(0);
            int colIndex = -1;
            StringBuilder foundHeaders = new StringBuilder();

            for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
                XSSFCell headerCell = headerRow.getCell(j);
                String headerText = (headerCell == null) ? "" : headerCell.toString().trim();
                foundHeaders.append("[").append(headerText).append("] ");
                if (headerText.equalsIgnoreCase(columnName)) {
                    colIndex = j;
                }
            }

            if (colIndex == -1) {
                throw new IllegalArgumentException(
                        "Column '" + columnName + "' not found in sheet '" + sheetName
                                + "'. Row 0 actually contains: " + foundHeaders);
            }

            int lastRow = sheet.getLastRowNum();
            Object[][] data = new Object[lastRow][1];

            for (int i = 1; i <= lastRow; i++) {
                XSSFRow row = sheet.getRow(i);
                XSSFCell cell = (row == null) ? null : row.getCell(colIndex);
                data[i - 1][0] = (cell == null) ? "" : cell.toString();
            }

            return data;
        }
    }
}