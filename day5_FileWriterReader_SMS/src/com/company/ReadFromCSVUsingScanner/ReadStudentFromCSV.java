package com.company.ReadFromCSVUsingScanner;

import com.company.WriteToCSV.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadStudentFromCSV {
    public static void main(String[] args) throws FileNotFoundException {

        //identify the path
        String path = "C:\\Users\\donat\\Documents\\to_be_done\\seven_seven_trainings\\day5_FileWriterReader_SMS\\src\\com\\company\\CreatedFiles\\Student.csv";
        //use Scanner
        Scanner scanner = new Scanner(new File(path));
        //create blank arrayList of students
        ArrayList<Student> students = new ArrayList<>();
        //start scanning, splitting and storing
        while (scanner.hasNext()){
            //use String array to store the split value
            String[] value = scanner.nextLine().split(",");
            //create Student object and store the array values to it
            Student student = new Student(
                    //need to use .parseLong() to be able print as string
                    Long.parseLong(value[0]),                                   //id
                    value[1],                                                   //name
                    //need to use .parseDouble() to be able print as string
                    Double.parseDouble(value[2])                                //grade
            );
            //add student object to students arrayList
            students.add(student);
        }
        //print
        System.out.println(students);
        scanner.close();


    }
}
