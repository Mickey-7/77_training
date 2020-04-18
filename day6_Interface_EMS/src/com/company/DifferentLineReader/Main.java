package com.company.DifferentLineReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        //retrieve a line at a specific line number from a file:

        //for small files:
        String line = Files.readAllLines(Paths.get(
                "C:\\Users\\donat\\Documents\\to be done\\seven_seven_trainings\\day6_Interface_EMS\\src\\com\\company\\EMS\\Employee.txt"
        )).get(1);
        System.out.println(line);       //output - 1,one,10.0,managerOne

        //for large files:
        String readLine;
        try(Stream<String> lines = Files.lines(Paths.get(
                "C:\\Users\\donat\\Documents\\to be done\\seven_seven_trainings\\day6_Interface_EMS\\src\\com\\company\\EMS\\Employee.txt"
        ))){
            readLine = lines.skip(1).findFirst().get();
            System.out.println(readLine);       //output - 1,one,10.0,managerOne
        }

        //for java 7:
        String lineReader;
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\donat\\Documents\\to be done\\seven_seven_trainings\\day6_Interface_EMS\\src\\com\\company\\EMS\\Employee.txt"))){
            for (int i = 0; i < 1; i++) {
                br.readLine();                      //discards lines
                lineReader = br.readLine();         //reads the line we're interested in
                System.out.println(lineReader);     //1,one,10.0,managerOne
            }
        }

        //display as a list
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(
                        "C:\\Users\\donat\\Documents\\to be done\\seven_seven_trainings\\day6_Interface_EMS\\src\\com\\company\\EMS\\Employee.txt"
        ), StandardCharsets.UTF_8)){
            List<String> lineRead = reader.lines()
                    .skip(1)
                    .limit(1)
                    .collect(Collectors.toList());
            System.out.println(lineRead);           //[1,one,10.0,managerOne]
        }


        //retrieve multiple line at a specific line number from a file:

        //for small files:
        //we need to put it on a forLoop
        for (int i = 0; i < 2; i++) {
            String lines = Files.readAllLines(Paths.get(
                    "C:\\Users\\donat\\Documents\\to be done\\seven_seven_trainings\\day6_Interface_EMS\\src\\com\\company\\EMS\\Employee.txt"
            )).get(i);
            System.out.println(lines);
            //id,name,salary,managerName
            //1,one,10.0,managerOne
        }

        //for large files:
        List<String> readsLine;
        try(Stream<String> lines = Files.lines(Paths.get(
                "C:\\Users\\donat\\Documents\\to be done\\seven_seven_trainings\\day6_Interface_EMS\\src\\com\\company\\EMS\\Employee.txt"
        ))){
            readsLine = lines
                    .skip(1)
                    .collect(Collectors.toList());
        }
        System.out.println(readsLine);
        //[1,one,10.0,managerOne, 2,two,20,0,managerTwo]

        //display as a list
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(
                "C:\\Users\\donat\\Documents\\to be done\\seven_seven_trainings\\day6_Interface_EMS\\src\\com\\company\\EMS\\Employee.txt"
        ), StandardCharsets.UTF_8)){
            List<String> lineRead = reader.lines()
                    .skip(1)
//                    .limit(1)
                    .collect(Collectors.toList());
            System.out.println(lineRead);
            //[1,one,10.0,managerOne, 2,two,20,0,managerTwo]
        }





    }
}
