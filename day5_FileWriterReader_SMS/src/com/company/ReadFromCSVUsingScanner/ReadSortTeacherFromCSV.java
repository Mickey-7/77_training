package com.company.ReadFromCSVUsingScanner;

import com.company.WriteToCSV.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadSortTeacherFromCSV {
    public static void main(String[] args) throws IOException {

        //identify the path
        String TeacherAnotherCSV = "C:\\Users\\donat\\Documents\\to_be_done\\seven_seven_trainings\\day5_FileWriterReader_SMS\\src\\com\\company\\CreatedFiles\\TeacherAnotherCSV.csv";

        System.out.println(ReadTeacherUsingScannerFromAnotherCSV(TeacherAnotherCSV));

        //need to make sure that the display on the console of the above method is not sorted
        SortTeacherUsingFileWriterFromAnotherCSV(TeacherAnotherCSV);

    }

    //ReadTeacher using scanner
    //output - arrayList of Teacher
    //input - String path
    private static ArrayList<Teacher> ReadTeacherUsingScannerFromAnotherCSV(String TeacherAnotherCSV) throws FileNotFoundException {
        //use scanner for reading
        Scanner scanner = new Scanner(new File(TeacherAnotherCSV));
        //create blank arrayList of teacher which we will store our teacher objects
        ArrayList<Teacher> teachers = new ArrayList<>();
        //iterate, split and store
        while (scanner.hasNext()){
            //need to create array of String which will hold split value
            String[] value = scanner.nextLine().split(",");
            //need to create Teacher object which will hold the String array
            Teacher teacher = new Teacher(
                    //use .parseLong() to display the id as string
                    Long.parseLong(value[0]),
                    value[1],
                    //use .parseDouble() to display the salary as string
                    Double.parseDouble(value[2])
            );
            //add teacher object to teachers arrayList
            teachers.add(teacher);
        }
        //don't forget to close scanner
        scanner.close();
        return  teachers;
    }

    //SortTeacher using FileWriter
    private static void SortTeacherUsingFileWriterFromAnotherCSV(String TeacherAnotherCSV) throws IOException {
        ArrayList<Teacher> teachers = ReadTeacherUsingScannerFromAnotherCSV(TeacherAnotherCSV);
        teachers.sort(((teacher, t1) -> {
            return (int) (teacher.getId()-t1.getId());
        }));
        FileWriter writer = new FileWriter(TeacherAnotherCSV);
        for(Teacher teacher : teachers){
            writer.append(
                    teacher.getId()+","+
                            teacher.getName()+","+
                            teacher.getSalary()+"\n"
            );

        }
        writer.close();
    }
}
