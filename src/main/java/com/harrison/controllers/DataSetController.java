package com.harrison.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.ai.domain.IrisEntity;
import com.harrison.ai.repository.IrisRepository;

@RestController
@RequestMapping("/api/data")
public class DataSetController {

    @Autowired
    private IrisRepository irisRepository;
    
    @RequestMapping(value = "/iris", method = RequestMethod.GET)
    public ResponseEntity<List<IrisEntity>> getIrisData() {
        return new ResponseEntity<>(irisRepository.findAll(), HttpStatus.OK);
    }
    
}
