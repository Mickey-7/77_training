package com.example.day25_SpringBoot_SMS.controller;

import com.example.day25_SpringBoot_SMS.domain.Student;
import com.example.day25_SpringBoot_SMS.domain.Teacher;
import com.example.day25_SpringBoot_SMS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("view/{id}")
    public Student viewStudent(@PathVariable Long id){
        return studentService.viewStudent(id);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PutMapping("editStudent/{id}")
    public Student editStudent(@PathVariable Long id,@RequestBody Student student){
        return studentService.editStudent(id,student);
    }

    @DeleteMapping("deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    //Search Students By First Name And Last Name
    @GetMapping("searchStudentByFirstAndLastName")
    public Student searchStudentByFirstAndLastName(@RequestParam String firstName, @RequestParam String lastName){
        return studentService.searchStudentByFirstAndLastName(firstName, lastName);
    }

    //- Search Teachers by Student Name (contains)
    @GetMapping("getTeacherByStudentName")
    public Teacher getTeacherByStudentName(@RequestParam String firstName  ){
        return studentService.getTeacherByStudentName(firstName);
    }

}
