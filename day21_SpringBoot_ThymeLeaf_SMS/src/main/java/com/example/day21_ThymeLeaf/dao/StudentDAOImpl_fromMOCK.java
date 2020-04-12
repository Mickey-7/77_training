package com.example.day21_ThymeLeaf.dao;

import com.example.day21_ThymeLeaf.domain.Student;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component(value = "MOCK")
public class StudentDAOImpl_fromMOCK  implements StudentDAO{
    @Override
    public List<Student> getAllStudents() {
        System.out.println("-------------------MOCK-------------------");
        return Arrays.asList(
                new Student(1L,"student1FromMOCK",10.0),
                new Student(2L,"student2FromMOCK",20.0),
                new Student(3L,"student3FromMOCK",30.0),
                new Student(4L,"student4FromMOCK",40.0)
        );
    }
}
