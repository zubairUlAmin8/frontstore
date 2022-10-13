package Helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile {
    public static void writeFile(String FileName, String Data) throws IOException {
        File file = new File("D:\\mywork\\automation\\Selenium\\frontstore\\Results\\BrokenLinksResults\\brokenLink.txt");
        if (file.exists()) {
            System.out.println("File created Successfully");
        } else {
            file.createNewFile();
        }

        try {
            FileWriter writer = new FileWriter("D:\\mywork\\automation\\Selenium\\frontstore\\Results\\BrokenLinksResults\\brokenLink.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.newLine();
            bufferedWriter.write(Data);


            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
