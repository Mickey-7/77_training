package com.company.FileOutputInputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOS {
    public static void main(String[] args) throws IOException {

        //create file path
        File file = new File("C:\\Users\\donat\\Documents\\to_be_done\\seven_seven_trainings\\day5_FileWriterReader_SMS\\src\\com\\company\\CreatedFiles\\FOS.txt");
        //check if file exist, if not then create it
        if(!file.exists()){
            file.createNewFile();
        }

        //using FOS to write content
        FileOutputStream fos = new FileOutputStream(file);
        //content to be written
        String content = "This is FOS created and Writing";
        fos.write(content.getBytes());
        fos.close();
    }
}
