package com.company.FileWriterReader;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterPractice {
    public static void main(String[] args) throws IOException {

        //path of the file
        String path = "C:\\Users\\donat\\Documents\\to_be_done\\seven_seven_trainings\\day5_FileWriterReader_SMS\\src\\com\\company\\CreatedFiles\\FileWriter.txt";
        //use FileWriter
        FileWriter writer = new FileWriter(path);
        //write to the file
        writer.write("this is a fileWriter writing");
        writer.close();
    }
}
