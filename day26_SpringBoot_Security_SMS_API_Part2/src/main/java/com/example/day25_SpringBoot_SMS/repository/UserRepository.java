package com.example.day25_SpringBoot_SMS.repository;

import com.example.day25_SpringBoot_SMS.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
