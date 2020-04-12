package com.example.day25_SpringBoot_SMS.repository;

import com.example.day25_SpringBoot_SMS.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Teacher findAllTeacherById(Long id);
    //- Search Students by Teacher's Last Name
    Teacher findAllTeacherByLastName(String lastName);
}
