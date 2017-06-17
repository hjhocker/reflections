package com.harrison.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.enums.Proficiency;
import com.harrison.suggestedskills.domain.SuggestedSkill;

@RestController
@RequestMapping(value = "/api/suggested/skills")
public class SuggestedSkillsController {

    @Autowired
    @Qualifier("suggestedSkillsDataSource")
    private DataSource suggestedSkillsDataSource;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SuggestedSkill>> getSkills() throws SQLException {
        String sql = "select * from suggested_skill";
        List<SuggestedSkill> list = new ArrayList<>();
        try (Connection conn = suggestedSkillsDataSource.getConnection(); 
                PreparedStatement ps = conn.prepareStatement(sql);) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    SuggestedSkill skill = new SuggestedSkill();
                    skill.setName(rs.getString("name"));
                    skill.setYearsOfExperience(Float.valueOf(rs.getString("years_of_experience")));
                    skill.setProficiency(Proficiency.valueOf(rs.getString("proficiency")));
                    list.add(skill);
                }
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
