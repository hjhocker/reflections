package com.harrison.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.domain.Skill;
import com.harrison.exceptions.DomainNotFoundException;
import com.harrison.repository.SkillRepository;

@RestController
@RequestMapping(value = "/api/skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Skill>> getSkills() {
        return new ResponseEntity<>(skillRepository.findAllOrderByYearsOfExperience(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Skill> getSkill(@PathVariable("name") String name) {
        return new ResponseEntity<>(skillRepository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        return new ResponseEntity<>(skillRepository.save(skill), HttpStatus.OK);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Skill> deleteSkill(@PathVariable("name") String name) {
        Skill skill = skillRepository.findByName(name);
        if (skill == null) {
            throw new DomainNotFoundException("No skills with name " + name + " found");
        }
        skillRepository.delete(skill);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }
}
