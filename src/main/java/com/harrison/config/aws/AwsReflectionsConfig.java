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
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.harrison.reflections.repository", 
        entityManagerFactoryRef = "reflectionsLocalEntityManagerFactoryBean",
        transactionManagerRef = "reflectionsPlatformTransactionManager")
@Profile("aws")
public class AwsReflectionsConfig {
    
    @Autowired
    private Environment env;
    
    @Bean(name = "reflectionsJdbcTemplate")
    public JdbcTemplate reflectionsJdbcTemplate() {
        return new JdbcTemplate(this.reflectionsDataSource());
    }
    
    @Primary
    @Bean(name = "reflectionsDataSource")
    public DataSource reflectionsDataSource() {
        return DataSourceBuilder.create()
                .url(env.getRequiredProperty("reflections.datasource.url"))
                .username(env.getRequiredProperty("reflections.datasource.username"))
                .password(env.getRequiredProperty("reflections.datasource.password"))
                .driverClassName(env.getRequiredProperty("reflections.datasource.driverClassName"))
                .build();
    }
    
    @Primary
    @Bean(name = "reflectionsLocalEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean reflectionsLocalEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", env.getRequiredProperty("reflections.hibernate.dialect"));
        return builder
                .dataSource(reflectionsDataSource())
                .packages("com.harrison.reflections.domain")
                .persistenceUnit("reflections")
                .build();
    }
    
    @Primary
    @Bean(name = "reflectionsPlatformTransactionManager")
    public PlatformTransactionManager reflectionsPlatformTransactionManager(
            @Qualifier("reflectionsLocalEntityManagerFactoryBean") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
