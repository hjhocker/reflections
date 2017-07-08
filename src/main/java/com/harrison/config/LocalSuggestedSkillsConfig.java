package com.harrison.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.harrison.suggestedskills.repository", 
        entityManagerFactoryRef = "suggestedSkillsLocalEntityManagerFactoryBean")
@Profile("local")
public class LocalSuggestedSkillsConfig {

    @Autowired
    private Environment env;
    
    @Bean(name = "suggestedSkillsDataSource")
    @FlywayDataSource
    public DataSource suggestedSkillsDataSource() throws IOException {
        return EmbeddedPostgres
                .builder()
                .setPort(15433)
                .start()
                .getPostgresDatabase();
    }

    @Bean(name = "suggestedSkillsLocalEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean suggestedSkillsLocalEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) throws IOException {
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
            @Qualifier("suggestedSkillsLocalEntityManagerFactoryBean") EntityManagerFactory suggestedSkillsLocalEntityManagerFactoryBean) {
        return new JpaTransactionManager(suggestedSkillsLocalEntityManagerFactoryBean);
    }
    
}
