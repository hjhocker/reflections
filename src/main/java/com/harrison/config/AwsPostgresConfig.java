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
        basePackages = "com.harrison.reflections.repository", 
        entityManagerFactoryRef = "reflectionsLocalEntityManagerFactory")
@Profile("aws")
public class AwsPostgresConfig {
    
    @Autowired
    private Environment env;
    
    @Bean(name = "reflectionsDataSource")
    public DataSource reflectionsDataSource() {
        return DataSourceBuilder.create()
                .url("reflections.datasource.url")
                .username("reflections.datasource.username")
                .password("reflections.datasource.password")
                .driverClassName("reflections.datasource.driverClassName")
                .build();
    }
    
    @Bean(name = "reflectionsLocalEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean reflectionsEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", env.getRequiredProperty("reflections.hibernate.dialect"));
        properties.put("hibernate.temp.use_jdbc_metadata_defaults", env.getRequiredProperty("false"));
        return builder
                .dataSource(reflectionsDataSource())
                .packages("com.harrison.reflections.domain")
                .persistenceUnit("reflections")
                .build();
    }

}
