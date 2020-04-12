package com.example.day21_ThymeLeaf.dao;

import com.example.day21_ThymeLeaf.domain.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Primary
@Component(value = "DB")
public class StudentDAOImpl_fromDB implements StudentDAO {
    @Override
    public List<Student> getAllStudents() {
        //to demonstrate @Value from application.properties
        System.out.println("PORT: "+dbPort+"\nDB: "+dbName+"\nUsername: "+dbUsername+"\nPassword"+dbPassword);

        System.out.println("-------------------DB-------------------");
        return Arrays.asList(
                new Student(1L,"student1FromDB",10.0),
                new Student(2L,"student2FromDB",20.0),
                new Student(3L,"student3FromDB",30.0),
                new Student(4L,"student4FromDB",40.0)
        );
    }

    @Value("${server.port}")
    private String dbPort;

    @Value("${db.url}")
    private String dbName;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;
}
