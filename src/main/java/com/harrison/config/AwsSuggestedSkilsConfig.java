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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.harrison.suggestedskills.repository", 
        entityManagerFactoryRef = "suggestedSkillsLocalEntityManagerFactory")
@Profile("aws")
public class AwsSuggestedSkilsConfig {

    @Autowired
    private Environment env;
    
    @Bean(name = "suggestedSkillsJdbcTempalte")
    public JdbcTemplate suggestedSkillsJdbcTempalte() {
        return new JdbcTemplate(suggestedSkillsDataSource());
    }
    
    @Bean(name = "suggestedSkillsDataSource")
    public DataSource suggestedSkillsDataSource() {
        return DataSourceBuilder.create()
                .url("suggestedSkills.datasource.url")
                .username("suggestedSkills.datasource.username")
                .password("suggestedSkills.datasource.password")
                .driverClassName("suggestedSkills.datasource.driverClass")
                .build();
    }
    
    @Bean(name = "suggestedSkillsLocalEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean suggestedSkillsEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", env.getRequiredProperty("suggestedSkills.hibernate.dialect"));
        properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        return builder
                .dataSource(suggestedSkillsDataSource())
                .packages("com.harrison.suggestedSkills.domain")
                .persistenceUnit("suggestedSkills")
                .build();
    }

}
