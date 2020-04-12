package com.example.day26_SpringBoot_Security.service;

import com.example.day26_SpringBoot_Security.domain.Student;
import com.example.day26_SpringBoot_Security.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    //no interface from repository - magic!!!!!!!
    public Student addStudent(Student student){
        //built-in .save() method is amazing!!!!!!!
        return studentRepository.save(student);
    }

    public List<Student> addAllStudent(List<Student> students){
        return studentRepository.saveAll(students);
    }

    //no interface from repository - magic!!!!!!!
    public List<Student> getAllStudents(){
        //built-in .findAll() method is amazing!!!!!!!
        return  studentRepository.findAll();
    }

    public List<Student> findAllByNameContaining(String name){
        return studentRepository.findAllByNameContaining(name);
    }

    public List<Student> custom(){
        return studentRepository.customQuery();
    }

    public List<Student> getAllStudentsGreaterThan(Double grade){
        return studentRepository.findAllByGradeGreaterThan(grade);
    }

}
