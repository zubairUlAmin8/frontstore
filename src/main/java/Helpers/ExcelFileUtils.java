package Helpers;

import BluePrint.LinkSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ExcelFileUtils {
    private static XSSFSheet sheet;

    private static XSSFWorkbook workbook;

    private static XSSFCell Cell;

    private static XSSFRow Row;
    public static int rownumber=0;

    public static File createFile() throws IOException {
        File file = new File("D:\\mywork\\automation\\Selenium\\frontstore\\Results\\BrokenLinksResults\\verifyBrokenLinksOnLandingPage.xlsx");
        if (file.exists()) {
//            System.out.println("file is already exits");


        } else {
            file.createNewFile();
        }
        return file;

    }

    public static void writeData(List<LinkSheet> statusSheet, String fileName) throws IOException {
         workbook = new XSSFWorkbook();
         sheet = workbook.createSheet();

        int rowCount = 0;

        for (LinkSheet aBook : statusSheet) {
            Row = sheet.createRow(++rowCount);
            writeBook(aBook, Row);
        }

        try (FileOutputStream outputStream = new FileOutputStream(".\\Results\\BrokenLinksResults\\"+fileName+".xlsx")) {
            workbook.write(outputStream);
        }
    }
    private static void writeBook(LinkSheet aBook, XSSFRow row) {

         Cell = row.createCell(1);
        Cell.setCellValue(aBook.getLink());

        Cell = row.createCell(2);
        Cell.setCellValue(aBook.getStatus());


    }


}
