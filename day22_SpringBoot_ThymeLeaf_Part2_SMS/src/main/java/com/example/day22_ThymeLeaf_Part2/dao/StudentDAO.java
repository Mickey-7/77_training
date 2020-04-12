package com.example.day22_ThymeLeaf_Part2.dao;

import com.example.day22_ThymeLeaf_Part2.domain.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    void addStudent(Student student);
    Student getStudentId(Long id);
    void updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
