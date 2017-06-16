package com.harrison.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.suggestedskills.domain.SuggestedSkill;
import com.harrison.suggestedskills.repository.SuggestedSkillRepository;

@RestController
@RequestMapping(value = "/api/suggested/skills")
public class SuggestedSkillsController {

    @Autowired
    private SuggestedSkillRepository suggestedSkillRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SuggestedSkill>> getSkills() {
        return new ResponseEntity<>(suggestedSkillRepository.findAll(), HttpStatus.OK);
    }

}
