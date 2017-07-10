package com.harrison.config.local;

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
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.harrison.reflections.repository", 
        entityManagerFactoryRef = "reflectionsLocalEntityManagerFactoryBean",
        transactionManagerRef = "reflectionsPlatformTransactionManager")
@Profile("local")
public class LocalReflectionsDbConfig {

    @Autowired
    private Environment env;
    
    @Bean(name = "reflectionsDataSource")
    @Primary
    @FlywayDataSource
    public DataSource reflectionsDataSource() throws IOException {
        return EmbeddedPostgres
                .builder()
                .setPort(15432)
                .start()
                .getPostgresDatabase();
    }

    @Primary
    @Bean(name = "reflectionsLocalEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean reflectionsLocalEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) throws IOException {
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
            @Qualifier("reflectionsLocalEntityManagerFactoryBean") EntityManagerFactory reflectionsLocalEntityManagerFactoryBean) {
        return new JpaTransactionManager(reflectionsLocalEntityManagerFactoryBean);
    }
}
