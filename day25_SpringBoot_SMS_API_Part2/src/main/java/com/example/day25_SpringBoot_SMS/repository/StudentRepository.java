package com.example.day25_SpringBoot_SMS.repository;

import com.example.day25_SpringBoot_SMS.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findAllStudentById(Long id);
    //Search Students By First Name And Last Name
    Student findByFirstNameAndLastName(String firstName, String lastName);
    //- Search Teachers by Student Name (contains)
    Student findByFirstNameContaining(String firstName);
}
