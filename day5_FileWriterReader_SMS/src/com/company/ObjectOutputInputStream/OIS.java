package com.company.ObjectOutputInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OIS {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //make sure you run OOS class first so that OOS.enc will have content
        //or else error below will occur
        //Exception in thread "main" java.io.EOFException

        //reading the encrypted hash-shit on OOS.enc
        //using FIS & OIS(decrypting -shit)
        FileInputStream fis = new FileInputStream("C:\\Users\\donat\\Documents\\to_be_done\\seven_seven_trainings\\day5_FileWriterReader_SMS\\src\\com\\company\\CreatedFiles\\OOS.enc");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object students = ois.readObject();
        System.out.println(students);
        ois.close();
        fis.close();



    }
}
