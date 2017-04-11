package city;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by promoscow on 12.04.17.
 */
public class ExcellCityView {
    public static void process(ArrayList<ArrayList<City>> towers) {

        System.out.println("Creating xls.");
        /**
         * Создание документа.
         */
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Компании Москва-Сити");
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Название");
        row.createCell(1).setCellValue("Описание");
        row.createCell(2).setCellValue("Телефон");
        row.createCell(3).setCellValue("Сайт");
        row.createCell(4).setCellValue("E-mail");
        for (ArrayList<City> tower : towers) {
            Row row1 = sheet.createRow(++rowNum);
            try {
                row1.createCell(0).setCellValue(tower.get(0).getTower().toUpperCase());
            } catch (NullPointerException | IndexOutOfBoundsException e) {
                System.out.println("null sheet");
                continue;
            }
            for (City company : tower) {
                if (company == null) continue;
                Row row2 = sheet.createRow(++rowNum);
                row2.createCell(0).setCellValue(company.getName());
                row2.createCell(1).setCellValue(company.getDescription());
                row2.createCell(2).setCellValue(company.getPhone());
                row2.createCell(3).setCellValue(company.getSite());
                row2.createCell(4).setCellValue(company.getEmail());
            }
        }

        try (FileOutputStream out = new FileOutputStream(new File("companies_full.xls"))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан!");
    }

//        System.out.println("Ready to create xls.");
//        /**
//         * Создание документа.
//         */
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        for (ArrayList<City> tower : towers) {
//            /**
//             * Создание листа.
//             */
//            HSSFSheet sheet = null;
//            try {
//                sheet = workbook.createSheet(tower.get(0).getTower());
//            } catch (NullPointerException | IndexOutOfBoundsException e) {
//                System.out.println("null sheet");
//                continue;
//            }
//            /**
//             * Создание строки Row номер rowNum.
//             */
//            int rowNum = 0;
//            Row row = sheet.createRow(rowNum);
//            row.createCell(0).setCellValue("Название");
//            row.createCell(1).setCellValue("Описание");
//            row.createCell(2).setCellValue("Телефон");
//            row.createCell(3).setCellValue("Сайт");
//            row.createCell(4).setCellValue("E-mail");
//            for (City company : tower) {
//                if (company == null) continue;
//                Row row1 = sheet.createRow(++rowNum);
//                row1.createCell(0).setCellValue(company.getName());
//                row1.createCell(1).setCellValue(company.getDescription());
//                row1.createCell(2).setCellValue(company.getPhone());
//                row1.createCell(3).setCellValue(company.getSite());
//                row1.createCell(4).setCellValue(company.getEmail());
//            }
//        }
//
//        try (FileOutputStream out = new FileOutputStream(new File("companies_full.xls"))) {
//            workbook.write(out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Excel файл успешно создан!");
}
