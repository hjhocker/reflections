package com.harrison.controllers;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspose.words.Document;
import com.aspose.words.SaveOutputParameters;
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
    public ResponseEntity<EmployeeWrite> createEmployee(@RequestBody EmployeeWrite employee) {
        return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public ResponseEntity<SaveOutputParameters> doStuff(@RequestBody  byte[] document) throws Exception {
        Document doc = new Document(new ByteArrayInputStream(document));
//        Document doc = new Document("/tmp/input.docx");
        SaveOutputParameters parameters = doc.save("/tmp/out.pdf");
        return new ResponseEntity<>(parameters, HttpStatus.OK);
    }
    
}
