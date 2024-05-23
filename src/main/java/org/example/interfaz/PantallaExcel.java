package org.example.interfaz;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PantallaExcel {

    public void generarExcel(List<List<Object>> arrayDatosVinos){

        Workbook workbook = new XSSFWorkbook();


        Sheet sheet = workbook.createSheet("excel-sheet");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);



        Row row0 = sheet.createRow(0);

        row0.createCell(0).setCellValue("Posicion");
        row0.createCell(1).setCellValue("Nombre");
        row0.createCell(2).setCellValue("Calificacion Somemlier");
        row0.createCell(3).setCellValue("Calificacion General");
        row0.createCell(4).setCellValue("Precio Sugerido");

        for (int i = 0; i < arrayDatosVinos.size(); i++) {
            System.out.println(arrayDatosVinos.get(i));

            Row row1 = sheet.createRow(i+1);

            row1.createCell(0).setCellValue(i+1);
            row1.createCell(1).setCellValue("test");
            row1.createCell(2).setCellValue(9999999);
            row1.createCell(3).setCellValue("william.john@gmail.com");
            row1.createCell(4).setCellValue("700000.00");
        }


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
