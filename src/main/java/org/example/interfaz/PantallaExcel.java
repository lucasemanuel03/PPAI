package org.example.interfaz;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class PantallaExcel {

    public void generarExcel(String[] nombres){
        //create a workbook
        Workbook workbook = new XSSFWorkbook();

        //create a sheet in the workbook
        Sheet sheet = workbook.createSheet("excel-sheet");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);

        for (int i = 0; i < ; i++) {
            
        }
        
        //create the 0th row using the createRow() method
        Row row0 = sheet.createRow(0);
        //create cell by using the createCell() method
        //and set the values to the cell by using the setCellValue() method
        row0.createCell(0).setCellValue("Posicion");
        row0.createCell(1).setCellValue("Nombre");
        row0.createCell(2).setCellValue("Calificacion Somemlier");
        row0.createCell(3).setCellValue("Calificacion General");
        row0.createCell(4).setCellValue("Precio Sugerido");

        //create the 1st row
        Row row1 = sheet.createRow(1);
        //insert data in the first row
        row1.createCell(0).setCellValue(1);
        row1.createCell(1).setCellValue("John William");
        row1.createCell(2).setCellValue(9999999);
        row1.createCell(3).setCellValue("william.john@gmail.com");
        row1.createCell(4).setCellValue("700000.00");

//create the 2nd row
        Row row2 = sheet.createRow(2);
//insert data in the second row
        row2.createCell(0).setCellValue(2);
        row2.createCell(1).setCellValue("MathewAAA Parker");
        row2.createCell(2).setCellValue(22222222);
        row2.createCell(3).setCellValue("parker.mathew@gmail.com");
        row2.createCell(4).setCellValue("200000.00");

//save the Excel file
        try {
            FileOutputStream out = new FileOutputStream(
                    new File("excelTEST.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("FUNCIONO");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
