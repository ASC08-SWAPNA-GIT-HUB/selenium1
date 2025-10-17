package pack1;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class lab14 {
    public static void main(String[] args) {
        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("UserDetails");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("First_Name");
            header.createCell(1).setCellValue("Last_Name");
            header.createCell(2).setCellValue("E-Mail");
            header.createCell(3).setCellValue("Telephone");
            header.createCell(4).setCellValue("Password");
            header.createCell(5).setCellValue("Password Confirm");

            Row data = sheet.createRow(1);
            data.createCell(0).setCellValue("Swapna");
            data.createCell(1).setCellValue("Gedela");
            data.createCell(2).setCellValue("swapna123@gmail.com");
            data.createCell(3).setCellValue("9876543210");
            data.createCell(4).setCellValue("Test@123");
            data.createCell(5).setCellValue("Test@123");

            try (FileOutputStream fileOut = new FileOutputStream("UserDetails.xls")) {
                workbook.write(fileOut);
                System.out.println("✅ UserDetails.xls created successfully!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
