package view; /**
 * Created by promoscow on 09.04.17.
 */

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import vo.School;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcellView {

    public static void process(List<School> schools) {
        System.out.println("Ready to create xls.");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Школы Москвы");
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Название школы");
        row.createCell(1).setCellValue("Адрес");
        row.createCell(2).setCellValue("Телефон");
        row.createCell(3).setCellValue("Директор");
        row.createCell(4).setCellValue("Рейтинг");
        for (School school : schools) {
            if (school == null) continue;
            Row row1 = sheet.createRow(++rowNum);
            row1.createCell(0).setCellValue(school.getName());
            row1.createCell(1).setCellValue(school.getFormattedAddress(school.getAddress()));
            row1.createCell(2).setCellValue(school.getPhone());
            row1.createCell(3).setCellValue(school.getDirector());
            row1.createCell(4).setCellValue(school.getRating());
        }

        try (FileOutputStream out = new FileOutputStream(new File("schools_full.xls"))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан!");
    }
}
