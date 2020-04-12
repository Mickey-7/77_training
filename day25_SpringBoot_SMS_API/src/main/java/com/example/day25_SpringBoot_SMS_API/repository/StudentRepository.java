package com.example.day25_SpringBoot_SMS_API.repository;

import com.example.day25_SpringBoot_SMS_API.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
