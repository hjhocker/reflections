package com.harrison.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.reflections.domain.EmployeeRead;
import com.harrison.reflections.domain.EmployeeWrite;
import com.harrison.reflections.repository.EmployeeReadRepository;
import com.harrison.reflections.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private EmployeeReadRepository employeeReadRepository;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmployeeRead> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeReadRepository.findByEmployeeId(id), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<EmployeeRead> createEmployee(@RequestBody EmployeeRead employee) {
        return new ResponseEntity<>(employeeReadRepository.save(employee), HttpStatus.OK);
    }
    
}
