package com.harrison.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FlywayConfig {

    @Autowired
    @Qualifier("reflectionsDataSource")
    private DataSource reflectionsDataSource;
    
    @Autowired
    @Qualifier("suggestedSkillsDataSource")
    private DataSource suggestedSkillsDataSource;
    
    @Bean(initMethod = "migrate")
    @Primary
    @FlywayDataSource
    public Flyway flyway() throws IOException {
        Flyway flyway = new Flyway();
        Properties properties = new Properties();
        flyway.setLocations("classpath:db/migration/reflections");
        flyway.configure(properties);
        flyway.setDataSource(reflectionsDataSource);
        return flyway;
    }
    
    @Bean(initMethod = "migrate")
    @FlywayDataSource
    public Flyway sugestedSkillsFlyway() throws IOException {
        Flyway flyway = new Flyway();
        Properties properties = new Properties();
        flyway.configure(properties);
        flyway.setLocations("classpath:db/migration/suggestedskills");
        flyway.setDataSource(suggestedSkillsDataSource);
        return flyway;
    }
    
}
