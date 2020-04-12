package com.example.day22_ThymeLeaf_Part2.service;

import com.example.day22_ThymeLeaf_Part2.dao.StudentDAO;
import com.example.day22_ThymeLeaf_Part2.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDAO studentDAO;
    public StudentService(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    public void addStudent(Student student){
        System.out.println("This is addStudent Service");
        //invoking studentDao
        studentDAO.addStudent(student);
    }

    public Student getStudentId(Long id){
        System.out.println("This is getStudentId Service");
        //invoking studentDao
        return studentDAO.getStudentId(id);
    }

    public List<Student> getAllStudents(){
        System.out.println("This is getAllStudents Service");
        //invoking studentDao
        return studentDAO.getAllStudents();
    }

    public void updateStudent(Long id,Student student){
        System.out.println("This is updateStudent Service");
        studentDAO.updateStudent(id,student);
    }

    public void deleteStudent(Long id ){
        System.out.println("This is deleteStudent Service");
        //invoking studentDao
        studentDAO.deleteStudent(id);
    }
}
