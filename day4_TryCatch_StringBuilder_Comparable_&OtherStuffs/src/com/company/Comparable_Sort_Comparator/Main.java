package com.company.Comparable_Sort_Comparator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Create a student class with id, name & grade
            //implement comparable by grade
            //sort array of students using Arrays.sort()
            //create a student comparator implementing Comparator (sort by name)


        //create array pf students
        Student[] students = {
                new Student(3,"three",50),
                new Student(5,"five",30),
                new Student(1,"one",70),
                new Student(6,"six",20),
                new Student(4,"four",40),
                new Student(7,"seven",10),
                new Student(2,"two",60),

        };

        //unsorted
        System.out.println("unsorted\n"+ Arrays.toString(students));
        System.out.println();

        //using Arrays.sort() to sort grade
        Arrays.sort(students);
        System.out.println("using Arrays.sort() to sort grade\n"+Arrays.toString(students));
        System.out.println();

        //using lambda comparator implementing Comparator (sort by name)
        Arrays.sort(students,((student, t1) -> {
            return student.getName().compareTo(t1.getName());
        }));
        System.out.println("using lambda comparator implementing Comparator (sort by name)\n"+ Arrays.toString(students));




    }
}
