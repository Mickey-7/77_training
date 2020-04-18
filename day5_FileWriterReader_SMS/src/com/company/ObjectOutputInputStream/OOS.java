package com.company.ObjectOutputInputStream;

import com.company.WriteToCSV.Student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OOS {
    public static void main(String[] args) throws IOException {

        //make sure the OOS.enc is clear

        //create an array of student
        Student[] student = {
                new Student(1,"stud1",10),
                new Student(2,"stud2",20),
                new Student(3,"stud3",30),
                new Student(4,"stud4",40),
                new Student(5,"stud5",50),
                new Student(6,"stud6",60),
                new Student(7,"stud7",70)
        };
        //create blank arrayList and add the created array of student
        List<Student> students = new ArrayList<>(Arrays.asList(student));

        //using FOS & OOS(for encrypted writing)
        FileOutputStream fos = new FileOutputStream("C:\\Users\\donat\\Documents\\to_be_done\\seven_seven_trainings\\day5_FileWriterReader_SMS\\src\\com\\company\\CreatedFiles\\OOS.enc");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(students);
        fos.close();
        oos.close();

        //encountering Error below
        //Exception in thread "main" java.io.NotSerializableException: com.company.WriteToCSV.Student
        //implements Serializable to the Student class is a must!!!!!!!


    }
}
