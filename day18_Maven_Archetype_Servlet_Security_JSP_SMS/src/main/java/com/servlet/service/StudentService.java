package com.servlet.service;

import com.servlet.dao.StudentDAO;
import com.servlet.domain.Student;

import java.util.List;

public class StudentService {
    //creating StudentDAO object
    private StudentDAO studentDAO;
    //invoking to constructor
    public StudentService(){
        this.studentDAO = new StudentDAO();
    }

    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    public List<Student> getSortedStudent(){
        return studentDAO.getSortedStudents();
    }

    public Student viewStudentByID(Long id){
        return studentDAO.viewStudentById(id);
    }

    public void addStudent(Student student){
        studentDAO.addStudent(student);
    }

}
