package com.example.day25_SpringBoot_SMS_API.service;

import com.example.day25_SpringBoot_SMS_API.domain.Student;
import com.example.day25_SpringBoot_SMS_API.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public Student viewStudent(Long id) {
        //.findById(Long id) -> output : Optional<Student>
        //.orElse(Student other) -> output : Student
        return studentRepository.findById(id).orElse(null);
    }

    public Student editStudent(Long id, Student student){
        studentRepository.findById(id)
                .map(student1 -> {
                    student1.setFirstName(student.getFirstName());
                    student1.setLastName(student.getLastName());
                    student1.setGrade(student.getGrade());
                    //save to studentRepository
                    return studentRepository.save(student1);
                });
        return null;
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

}
