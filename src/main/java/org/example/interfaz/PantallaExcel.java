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
        for (int i = 0; i < 9; i++) {
            sheet.setColumnWidth(i, 5000);
        }

        Row row0 = sheet.createRow(0);

        row0.createCell(0).setCellValue("Posición");
        row0.createCell(1).setCellValue("Nombre");
        row0.createCell(2).setCellValue("Calificación General");
        row0.createCell(3).setCellValue("Calificación Sommelier");
        row0.createCell(4).setCellValue("Precio Sugerido");
        row0.createCell(5).setCellValue("Bodega");
        row0.createCell(6).setCellValue("Región");
        row0.createCell(7).setCellValue("País");
        row0.createCell(8).setCellValue("Varietal");

        for (int i = 0; i < arrayDatosVinos.size(); i++) {
            List<Object> vino = arrayDatosVinos.get(i);

            Row row1 = sheet.createRow(i+1);

            row1.createCell(0).setCellValue(i+1);
            row1.createCell(1).setCellValue(vino.get(1).toString());
            row1.createCell(2).setCellValue(7);
            row1.createCell(3).setCellValue(vino.get(0).toString());
            row1.createCell(4).setCellValue(vino.get(2).toString());
            row1.createCell(5).setCellValue(vino.get(3).toString());
            row1.createCell(6).setCellValue(vino.get(4).toString());
            row1.createCell(7).setCellValue(vino.get(5).toString());
            row1.createCell(8).setCellValue(vino.get(6).toString());
        }


        try {
            FileOutputStream out = new FileOutputStream(
                    new File("ranking-10-Vinos.xlsx"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
