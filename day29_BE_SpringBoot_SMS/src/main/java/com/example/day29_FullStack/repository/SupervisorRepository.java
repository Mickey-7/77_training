package com.example.day29_FullStack.repository;

import com.example.day29_FullStack.domain.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor,Long> {
}
