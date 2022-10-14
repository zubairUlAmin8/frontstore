package Helpers;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExcelFileUtils {
    private static XSSFSheet sheet;

    private static XSSFWorkbook workbook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    public static File createFile() throws IOException {
        File file = new File("D:\\mywork\\automation\\Selenium\\frontstore\\Results\\BrokenLinksResults\\brokenLinks.xlsx");
        if (file.exists()) {
            System.out.println("file is already exits");

        } else {
            file.createNewFile();
        }
        return file;

    }
    public static void writeData(int rowNumber, String Data) throws IOException {

//        FileInputStream ExcelFile = new FileInputStream(file);

         workbook = new XSSFWorkbook();

        // Creating a blank Excel sheet
         sheet
                = workbook.createSheet("student Details");

        // Creating an empty TreeMap of string and Object][]
        // type
        Map<String, Object[]> data
                = new TreeMap<String, Object[]>();

        // Writing data to Object[]
        // using put() method
        data.put("1",
                new Object[] { "ID", "NAME", "LASTNAME" });
        data.put("2",
                new Object[] { 1, "Pankaj", "Kumar" });
        data.put("3",
                new Object[] { 2, "Prakashni", "Yadav" });
        data.put("4", new Object[] { 3, "Ayan", "Mondal" });
        data.put("5", new Object[] { 4, "Virat", "kohli" });

        // Iterating over data and writing it to sheet
        Set<String> keyset = data.keySet();

        int rownum = 0;

        for (String key : keyset) {

            // Creating a new row in the sheet
             Row = sheet.createRow(rownum++);

            Object[] objArr = data.get(key);

            int cellnum = 0;

            for (Object obj : objArr) {

                // This line creates a cell in the next
                //  column of that row
                Cell = Row.createCell(cellnum++);

                if (obj instanceof String)
                    Cell.setCellValue((String)obj);

                else if (obj instanceof Integer)
                    Cell.setCellValue((Integer)obj);
            }
        }

        // Try block to check for exceptions

        try {

            // Writing the workbook
            File file=createFile();
            FileOutputStream out = new FileOutputStream(file);

            workbook.write(out);

            // Closing file output connections
            out.close();

            // Console message for successful execution of
            // program
            System.out.println(
                    "brokenLinks.xlsx written successfully on disk.");
        }

        // Catch block to handle exceptions
        catch (Exception e) {

            // Display exceptions along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
    }

}
