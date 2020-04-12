package com.example.day22_ThymeLeaf_Part2.dao;

import com.example.day22_ThymeLeaf_Part2.domain.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class StudentDAOImpl implements StudentDAO{
    //create blank list of students
    private List<Student> students = new ArrayList<>();


    @Override
    public void addStudent(Student student) {
        //set the student credentials then add to list
        student.setId(student.getId());
        student.setName(student.getName());
        student.setGrade(student.getGrade());
        students.add(student);
        System.out.println("Student Added");
    }

    @Override
    public Student getStudentId(Long id) {
        System.out.println("Student Displayed ID");
        return Optional.ofNullable(students)
                .orElse(Collections.emptyList())
                .stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public List<Student> getAllStudents() {
        System.out.println("Students Displayed");
        return students;
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Student studentWithId = getStudentId(id);
        studentWithId.setId(student.getId());
        studentWithId.setName(student.getName());
        studentWithId.setGrade(student.getGrade());
        System.out.println("Student Updated");
    }

    @Override
    public void deleteStudent(Long id) {
        Optional.ofNullable(students)
                .orElse(Collections.emptyList())
                .removeIf(student -> student.getId().equals(id));

    }
}
