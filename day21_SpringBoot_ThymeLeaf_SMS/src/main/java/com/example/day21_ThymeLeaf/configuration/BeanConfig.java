package com.example.day21_ThymeLeaf.configuration;

import com.example.day21_ThymeLeaf.domain.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class BeanConfig {
    @Bean
    public Student baseStudent(){
        return new Student(new Random().nextLong(),"Student Bean",new Random().nextDouble());
    }
}
