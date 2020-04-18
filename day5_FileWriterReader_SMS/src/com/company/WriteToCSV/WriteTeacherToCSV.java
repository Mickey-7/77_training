package com.company.WriteToCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteTeacherToCSV {
    public static void main(String[] args) throws IOException {


        //using FileWriter
        String path = "C:\\Users\\donat\\Documents\\to_be_done\\seven_seven_trainings\\day5_FileWriterReader_SMS\\src\\com\\company\\CreatedFiles\\Teacher.csv";
        FileWriter writer = new FileWriter(path);

//        //create array of teachers - not used but another alternative way
//        Teacher[] teachers = {
//                new Teacher(1,"teacher1",77000),
//                new Teacher(2,"teacher2",77000),
//                new Teacher(3,"teacher3",77000),
//                new Teacher(4,"teacher4",77000),
//                new Teacher(5,"teacher5",77000),
//                new Teacher(6,"teacher6",77000),
//                new Teacher(7,"teacher7",77000)
//        };
        //creating arrayList of teachers
        ArrayList<Teacher> teacherArrayList = new ArrayList<>(
                //another alternative way
//                Arrays.asList(teachers)

                //directly adding dummy data to arrayList - another option
            Arrays.asList(
                new Teacher(1,"teacher1",77000),
                new Teacher(2,"teacher2",77000),
                new Teacher(3,"teacher3",77000),
                new Teacher(4,"teacher4",77000),
                new Teacher(5,"teacher5",77000),
                new Teacher(6,"teacher6",77000),
                new Teacher(7,"teacher7",77000)
            )
        );
        for(Teacher teacher : teacherArrayList){
            writer.write(teacher.getId()+","+teacher.getName()+","+teacher.getSalary()+"\n");
        }
        writer.close();
    }
}
