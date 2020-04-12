package com.example.day21_ThymeLeaf.service;

import com.example.day21_ThymeLeaf.dao.StudentDAO;
import com.example.day21_ThymeLeaf.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Qualifier("DB")      //pertains to source - can "DB" or "MOCK" - see dao @Component(value)
    @Autowired
    private StudentDAO studentDAO;
    public StudentService(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    public List<Student> getAllStudents(){
        System.out.println("This is StudentService");
        //invoking the StudentDAO followed by . operator to get the method
        return studentDAO.getAllStudents();
    }
}
