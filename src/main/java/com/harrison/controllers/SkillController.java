package com.harrison.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.reflections.domain.Skill;
import com.harrison.reflections.repository.SkillRepository;

@RestController
@RequestMapping(value = "/api/skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;
    
    @Autowired
    @Qualifier("reflectionsPlatformTransactionManager")
    private PlatformTransactionManager transactionManager;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Skill>> getSkills() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        List<Skill> skills = transactionTemplate.execute(new TransactionCallback<List<Skill>>() {
            @Override
            public List<Skill> doInTransaction(TransactionStatus status) {
                return skillRepository.findAllOrderByYearsOfExperience();
            }
        });
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Skill> getSkill(@PathVariable("name") String name) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        Skill skill = transactionTemplate.execute(new TransactionCallback<Skill>() {
            @Override
            public Skill doInTransaction(TransactionStatus status) {
                return skillRepository.findByName(name);
            }
        });
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

}
