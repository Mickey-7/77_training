package com.company;

import com.company.Exercise.School;
import com.company.Exercise.Student;
import com.company.Exercise.Teacher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        School school = new School();
        List<Teacher> teacherList = new ArrayList<>();

        List<Student> students1 = new ArrayList<>();
        Student student11 = new Student(1L,"s1",10.0,LocalDateTime.now(),LocalDateTime.now());
        students1.add(student11);
        List<Student> students2 = new ArrayList<>();
        Student student22 = new Student(2L,"s2",20.0,LocalDateTime.now(),LocalDateTime.now());
        students2.add(student22);
        List<Student> students3 = new ArrayList<>();
        Student student33 = new Student(3L,"s3",30.0,LocalDateTime.now(),LocalDateTime.now());
        students3.add(student33);

        Teacher teacher11 = new Teacher(1L,"t1",students1,LocalDateTime.now(),LocalDateTime.now());
        teacherList.add(teacher11);
        Teacher teacher22 = new Teacher(2L,"t2",students2,LocalDateTime.now(),LocalDateTime.now());
        teacherList.add(teacher22);
        Teacher teacher33 = new Teacher(3L,"t3",students3,LocalDateTime.now(),LocalDateTime.now());
        teacherList.add(teacher33);

        school.setTeachers(teacherList);

        System.out.println(school);
        System.out.println(school.getTeachers());
        for(Teacher teacher : teacherList){
            System.out.println(teacher.getStudents());
        }




    }
}
