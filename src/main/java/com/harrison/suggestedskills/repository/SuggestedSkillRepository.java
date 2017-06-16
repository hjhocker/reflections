package com.harrison.suggestedskills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harrison.suggestedskills.domain.SuggestedSkill;

@Repository
public interface SuggestedSkillRepository extends JpaRepository<SuggestedSkill, Long> {
    
}
