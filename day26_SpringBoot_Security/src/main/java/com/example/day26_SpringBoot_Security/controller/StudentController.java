package com.example.day26_SpringBoot_Security.controller;

import com.example.day26_SpringBoot_Security.domain.Student;
import com.example.day26_SpringBoot_Security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PostMapping("addStudents")
    public List<Student> addAllStudent(@RequestBody List<Student> students){
        return studentService.addAllStudent(students);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("searchName")
    public List<Student> findAllByNameContaining(@RequestParam String name){
        return  studentService.findAllByNameContaining(name);
    }

    @GetMapping("customQuery")
    public List<Student> custom(){
        return studentService.custom();
    }

    @GetMapping("getGrade")
    public List<Student> getAllStudentsGreaterThan(@RequestParam Double grade){
        return studentService.getAllStudentsGreaterThan(grade);
    }
}
