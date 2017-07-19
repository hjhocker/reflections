package com.harrison.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.ai.domain.IrisEntity;
import com.harrison.ai.repository.IrisRepository;

import libsvm.svm;
import libsvm.svm_model;

@RestController
@RequestMapping("/api/ai/iris/svm")
public class IrisSvmController {

    @Autowired
    private IrisRepository irisRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public void svm() {
        List<IrisEntity> irisData = irisRepository.findAll();
        svm svm = new svm();
        svm_model model = new svm_model();
        model.nr_class = 3;
    }
    
}
