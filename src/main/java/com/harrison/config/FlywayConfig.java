package com.harrison.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FlywayConfig {

    @Autowired
    private DataSource reflectionsDataSource;
    
    @Autowired
    private DataSource suggestedSkillsDataSource;
    

    

}
