package com.harrison.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.suggestedskills.domain.SuggestedSkill;

@RestController
@RequestMapping(value = "/suggested/api/skills")
public class SuggestedSkillController {

    @Autowired
    private JdbcTemplate suggestedSkillsJdbTempalte;
    
//    @Autowired
//    private Jdbc
    
    @GetMapping
    public List<SuggestedSkill> get() {
//        suggestedSkillsJdbTempalte.execut
        return null;
    }
    
}
