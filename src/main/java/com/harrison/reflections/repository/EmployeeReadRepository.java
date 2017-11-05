package com.harrison.reflections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harrison.reflections.domain.EmployeeRead;
import com.harrison.reflections.domain.EmployeeWrite;

@Repository
public interface EmployeeReadRepository extends JpaRepository<EmployeeRead, Long> {
    
    EmployeeRead findByEmployeeId(Long id);
    
}
