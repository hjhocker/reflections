package com.harrison.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.reflections.domain.Name;
import com.harrison.reflections.repository.NameRepository;

@RestController
@RequestMapping(value = "/api/name")
public class NameController {

    @Autowired
    private NameRepository nameRepository;

    @RequestMapping(value = "/full", method = RequestMethod.GET)
    public ResponseEntity<String> getFullName() {
        Name name = nameRepository.findAll().get(0);
        String fullName = name.getFirstName() + " " + name.getMiddleName() + " " + name.getLastName();
        return new ResponseEntity<>(fullName, HttpStatus.OK);
    }

    @RequestMapping(value = "/firstlast", method = RequestMethod.GET)
    public ResponseEntity<String> getFirstLastName() {
        Name name = nameRepository.findAll().get(0);
        String firstlast = name.getFirstName() + " " + name.getLastName();
        return new ResponseEntity<>(firstlast, HttpStatus.OK);
    }

}
