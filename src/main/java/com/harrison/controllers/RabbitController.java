package com.harrison.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.messaging.Sender;

@RestController
@RequestMapping(value = "/api/rabbit")
public class RabbitController {

    @Autowired
    private Sender sender;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<String> send() {
        sender.send();
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    
}
