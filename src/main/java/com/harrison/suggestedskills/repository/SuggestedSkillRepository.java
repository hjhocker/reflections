package com.harrison.suggestedskills.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harrison.suggestedskills.domain.SuggestedSkill;

public interface SuggestedSkillRepository extends JpaRepository<SuggestedSkill, Long> {

    List<SuggestedSkill> findByName();
    
}
