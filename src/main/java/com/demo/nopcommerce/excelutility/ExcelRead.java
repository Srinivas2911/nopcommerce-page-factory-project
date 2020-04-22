package com.demo.nopcommerce.excelutility;

/*
Created by SP
*/

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelRead {
// to collect data from the excel worksheet provided in the testdata package

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");

        XSSFWorkbook excelWBook;
        XSSFSheet excelWSheet;
        XSSFCell Cell;

        // Location of the Excel file
        String path = projectPath + "/src/test/java/com/demo/nopcommerce/resources/testdata/NewDataSheet.xlsx";
        String sheetName = "NewDataSheet";

        try {
            FileInputStream ExcelFile = new FileInputStream(path);
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(sheetName);

            Cell = excelWSheet.getRow(1).getCell(2);
            String cellData = Cell.getStringCellValue();
            System.out.println("Cell Data: " + cellData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

