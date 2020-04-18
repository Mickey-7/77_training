package com.company.FileWriterReader;


import java.io.FileReader;
import java.io.IOException;

public class FileReaderPractice {
    public static void main(String[] args) throws IOException {

        //path of the file
        String path = "C:\\Users\\donat\\Documents\\to_be_done\\seven_seven_trainings\\day5_FileWriterReader_SMS\\src\\com\\company\\CreatedFiles\\FileReader.txt";
        //use FileWriter
        FileReader reader = new FileReader(path);
        //read the file
        reader.read();
        int content;
        while ((content=reader.read())!=-1){
            //need to convert int to char
            System.out.print((char) content);
        }
        reader.close();
    }
}
