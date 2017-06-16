package com.harrison.suggestedskills.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.harrison.enums.Proficiency;
import com.harrison.enums.ProficiencyConverter;

@Entity
@Table(name = "suggested_skill")
public class SuggestedSkill implements Serializable {

    private static final long serialVersionUID = 1821162015051593151L;

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "years_of_experience")
    private float yearsOfExperience;

    @Column(name = "proficiency")
    @Convert(converter = ProficiencyConverter.class)
    private Proficiency proficiency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public void setProficiency(Proficiency proficiency) {
        this.proficiency = proficiency;
    }

    
}
