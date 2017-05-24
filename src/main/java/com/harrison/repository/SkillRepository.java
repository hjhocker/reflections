package com.harrison.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.harrison.domain.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

	Skill findByName(String name);

	@Query(nativeQuery = true, value = "select * from skill order by years_of_experience desc, name asc")
	List<Skill> findAllOrderByYearsOfExperience();
}
