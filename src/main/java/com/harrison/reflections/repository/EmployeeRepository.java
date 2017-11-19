package com.harrison.reflections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harrison.reflections.domain.EmployeeWrite;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeWrite, Long> {
    
    EmployeeWrite findByEmployeeId(Long id);
    
}
