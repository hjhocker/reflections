package com.harrison.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
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
    @Qualifier("suggestedSkillsPlatformTransactionManager")
    private PlatformTransactionManager transactionManager;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Skill>> getSkills() {
        return new ResponseEntity<>(skillRepository.findAllOrderByYearsOfExperience(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Skill> getSkill(@PathVariable("name") String name) {
        TransactionStatus trans = transactionManager.getTransaction(new TransactionDefinition() {
            
            @Override
            public boolean isReadOnly() {
                // TODO Auto-generated method stub
                return false;
            }
            
            @Override
            public int getTimeout() {
                // TODO Auto-generated method stub
                return 0;
            }
            
            @Override
            public int getPropagationBehavior() {
                // TODO Auto-generated method stub
                return 0;
            }
            
            @Override
            public String getName() {
                // TODO Auto-generated method stub
                return null;
            }
            
            @Override
            public int getIsolationLevel() {
                // TODO Auto-generated method stub
                return 1;
            }
        });
        return new ResponseEntity<>(skillRepository.findByName(name), HttpStatus.OK);
    }

}
