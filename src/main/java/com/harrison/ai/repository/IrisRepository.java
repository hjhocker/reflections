package com.harrison.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harrison.ai.domain.IrisEntity;

@Repository
public interface IrisRepository extends JpaRepository<IrisEntity, Long> {

}
