package com.example.day24_JPA_MySQL_SMS.repository;

import com.example.day24_JPA_MySQL_SMS.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByNameContaining(String name);

    @Query(value = "select * from student where grade > 90",nativeQuery = true)
    List<Student> customQuery();

    List<Student> findAllByGradeGreaterThan(Double grade);


}
