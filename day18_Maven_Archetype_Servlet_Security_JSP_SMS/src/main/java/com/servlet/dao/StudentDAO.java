package com.servlet.dao;

import com.servlet.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    //creating mock data
    private static List<Student> students = new ArrayList<>();

    static {
                students.add(new Student(2L,"student2",20.0));
                students.add(new Student(4L,"student4",40.0));
                students.add(new Student(1L,"student1",10.0));
                students.add(new Student(3L,"student3",30.0));

    }
    //end of creation

    //getAllStudent
    public List<Student> getAllStudents(){
        return students;
    }

    //getSortedStudents
    public List<Student> getSortedStudents(){
        students.sort((student, t1) -> student.getName().compareTo(t1.getName()));
        return students;
    }

    //viewStudentById
    public Student viewStudentById(Long id){
        for (Student student : students){
            if (student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    //addStudent
    public void addStudent(Student student){
        students.add(student);
    }
}
