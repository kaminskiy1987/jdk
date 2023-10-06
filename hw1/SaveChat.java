package jdk.hw1;

import javax.swing.*;
import java.io.*;

public class SaveChat {
    private static File file = new File("file.txt");
    public static void write(JTextArea fieldChat)  throws Exception{
        FileWriter writer = new FileWriter(file);
        writer.write(fieldChat.getText());
        writer.flush();
        writer.close();
    }

    public static void read(JTextArea fieldChat) throws IOException {
        if (!file.exists()) file.createNewFile();
        try(BufferedReader br= new BufferedReader(new FileReader(file))){
            int count=getLineCount(file.toString());
            StringBuilder stringBuilder=new StringBuilder();
            while(count>0) {
                stringBuilder.append(br.readLine()+"\n");
                count--;
            }
            fieldChat.setText(stringBuilder.toString());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static int getLineCount(String fileName) throws Exception {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        }
    }
}