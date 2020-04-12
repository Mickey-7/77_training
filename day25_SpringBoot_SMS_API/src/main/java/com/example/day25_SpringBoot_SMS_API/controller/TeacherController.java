package com.example.day25_SpringBoot_SMS_API.controller;

import com.example.day25_SpringBoot_SMS_API.domain.Student;
import com.example.day25_SpringBoot_SMS_API.domain.Teacher;
import com.example.day25_SpringBoot_SMS_API.service.StudentService;
import com.example.day25_SpringBoot_SMS_API.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    private TeacherService teacherService;
    //adding StudentService for addStudentToTeacher
    private StudentService studentService;
    @Autowired
    public TeacherController(TeacherService teacherService,StudentService studentService){
        this.teacherService = teacherService;
        //adding StudentService for addStudentToTeacher
        this.studentService = studentService;
    }


    @GetMapping("viewTeacher/{id}")
    public Teacher viewTeacher(@PathVariable Long id){
        return teacherService.viewTeacher(id);
    }

    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }

    @PutMapping("editTeacher/{id}")
    public Teacher editTeacher(@PathVariable Long id, @RequestBody Teacher teacher){
        return teacherService.editTeacher(id,teacher);
    }

    @DeleteMapping("deleteTeacher/{id}")
    public void deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);
    }

    @PostMapping("/{teacherId}/addStudent/{studentID}")
    public Student addStudentToTeacher(@PathVariable Long teacherId, @PathVariable Long studentID){
        return teacherService.addStudentToTeacher(teacherId, studentID);
    }

}
