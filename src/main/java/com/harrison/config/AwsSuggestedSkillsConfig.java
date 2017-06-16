package com.harrison.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.harrison.suggestedskills.repository", 
        entityManagerFactoryRef = "suggestedSkillsLocalEntityManagerFactoryBean")
@Profile("aws")
public class AwsSuggestedSkillsConfig {
    
    @Autowired
    private Environment env;
    
    @Bean(name = "suggestedSkillsDataSource")
    public DataSource suggestedSkillsDataSource() {
        return DataSourceBuilder.create()
                .url(env.getRequiredProperty("suggestedSkills.datasource.url"))
                .username(env.getRequiredProperty("suggestedSkills.datasource.username"))
                .password(env.getRequiredProperty("suggestedSkills.datasource.password"))
                .driverClassName(env.getRequiredProperty("suggestedSkills.datasource.driverClassName"))
                .build();
    }
    
    @Bean(name = "suggestedSkillsLocalEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean suggestedSkillsLocalEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", env.getRequiredProperty("suggestedSkills.hibernate.dialect"));
        return builder
                .dataSource(suggestedSkillsDataSource())
                .packages("com.harrison.suggestedskills.domain")
                .persistenceUnit("suggestedSkills")
                .build();
    }

}