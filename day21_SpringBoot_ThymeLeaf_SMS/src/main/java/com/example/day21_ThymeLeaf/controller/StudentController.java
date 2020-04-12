package com.example.day21_ThymeLeaf.controller;

import com.example.day21_ThymeLeaf.domain.Student;
import com.example.day21_ThymeLeaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("viewStudents")     //pertains to url web browser
    public String viewStudents(){
        System.out.println("This is StudentController");
        //invoking the studentService
        System.out.println(studentService.getAllStudents());
        return "students";          //pertains to students.html
    }

    @Autowired
    private Student baseStudent;
    @GetMapping("beanStudent")          //pertains to url web browser
    public String viewBaseStudent(){
        System.out.println("This is from BeanConfig");
        System.out.println(baseStudent);
        return "students";       //pertains to students.html
    }

}
