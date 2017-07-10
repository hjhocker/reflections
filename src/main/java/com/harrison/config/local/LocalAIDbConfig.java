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
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.harrison.ai.repository", 
        entityManagerFactoryRef = "aiLocalEntityManagerFactoryBean",
        transactionManagerRef = "aiPlatformTransactionManager")
@Profile("local")
public class LocalAIDbConfig {

    @Autowired
    private Environment env;

    @Bean(name = "aiJdbcTemplate")
    public JdbcTemplate aiJdbcTempalte() throws IOException {
        return new JdbcTemplate(this.aiDataSource());
    }

    @Bean(name = "aiDataSource")
    @FlywayDataSource
    public DataSource aiDataSource() throws IOException {
        return EmbeddedPostgres
                .builder()
                .setPort(15431)
                .start()
                .getPostgresDatabase();
    }

    @Bean(name = "aiLocalEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean aiLocalEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) throws IOException {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", env.getRequiredProperty("ai.hibernate.dialect"));
        return builder
                .dataSource(aiDataSource())
                .packages("com.harrison.ai.domain")
                .persistenceUnit("ai")
                .build();
    }

    @Bean(name = "aiPlatformTransactionManager")
    public PlatformTransactionManager aiPlatformTransactionManager(
            @Qualifier("aiLocalEntityManagerFactoryBean") EntityManagerFactory aiLocalEntityManagerFactoryBean) {
        return new JpaTransactionManager(aiLocalEntityManagerFactoryBean);
    }
}
