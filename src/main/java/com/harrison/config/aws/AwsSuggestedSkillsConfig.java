package com.harrison.config.aws;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.harrison.suggestedskills.repository", 
        entityManagerFactoryRef = "suggestedSkillsLocalEntityManagerFactoryBean",
        transactionManagerRef = "suggestedSkillsPlatformTransactionManager")
@Profile("aws")
public class AwsSuggestedSkillsConfig {
    
    @Autowired
    private Environment env;
    
    @Bean(name = "suggestedSkillsJdbcTemplate")
    public JdbcTemplate suggestedSkillsJdbcTemplate() {
        return new JdbcTemplate(this.suggestedSkillsDataSource());
    }
    
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
    
    @Bean(name = "suggestedSkillsPlatformTransactionManager")
    public PlatformTransactionManager suggestedSkillsPlatformTransactionManager(
            @Qualifier("suggestedSkillsLocalEntityManagerFactoryBean") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
