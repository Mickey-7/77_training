package com.company.WriteToCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteStudentToCSV {
    public static void main(String[] args) throws IOException {

        //using FileWriter
        String path = "C:\\Users\\donat\\Documents\\to_be_done\\seven_seven_trainings\\day5_FileWriterReader_SMS\\src\\com\\company\\CreatedFiles\\Student.csv";
        FileWriter writer = new FileWriter(path);

        //create array of students
        Student[] students = {
                new Student(1,"stud1",10),
                new Student(2,"stud1",20),
                new Student(3,"stud1",30),
                new Student(4,"stud1",40),
                new Student(5,"stud1",50),
                new Student(6,"stud1",60),
                new Student(7,"stud7",70)
        };
        //creating arrayList of students
        ArrayList<Student> studentsArrayList = new ArrayList<>(
                Arrays.asList(students)

                //directly adding dummy data to arrayList - another option
//            Arrays.asList(
//                    new Student(1,"stud1",10),
//                    new Student(2,"stud1",20),
//                    new Student(3,"stud1",30),
//                    new Student(4,"stud1",40),
//                    new Student(5,"stud1",50),
//                    new Student(6,"stud1",60),
//                    new Student(7,"stud7",70)
//            )
        );
        for(Student stud : studentsArrayList){
            writer.write(stud.getId()+","+stud.getName()+","+stud.getGrade()+"\n");
        }
        writer.close();


    }
}
