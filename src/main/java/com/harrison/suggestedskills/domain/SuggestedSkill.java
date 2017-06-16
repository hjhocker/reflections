package com.harrison.suggestedskills.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "suggested_skill")
public class SuggestedSkill {

    @Id
    @Column(name = "name")
    private String name;
    
}
