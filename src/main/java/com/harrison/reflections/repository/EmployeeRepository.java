package com.harrison.reflections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harrison.reflections.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    Employee findByEmployeeId(Long id);
    
}
