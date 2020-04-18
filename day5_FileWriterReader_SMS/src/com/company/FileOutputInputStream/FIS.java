package com.company.FileOutputInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FIS {
    public static void main(String[] args) throws IOException {

        //create file path
        File file = new File("C:\\Users\\donat\\Documents\\to_be_done\\seven_seven_trainings\\day5_FileWriterReader_SMS\\src\\com\\company\\CreatedFiles\\FIS.txt");
        //check if file exist, if not then create it
        if(!file.exists()){
            file.createNewFile();
        }

        //using FIS to read content
        FileInputStream fis = new FileInputStream(file);
        int content;
        while ((content=fis.read())!=-1){
            //need to convert the int to char
            System.out.print((char) content);
        }
        fis.close();


    }
}
