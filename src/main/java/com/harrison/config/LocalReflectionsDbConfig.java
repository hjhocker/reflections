package com.harrison.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

@Component
@EnableJpaRepositories(
        basePackages = "com.harrison.reflections.repository")
@Profile("local")
public class LocalReflectionsDbConfig {

    @Bean(initMethod = "migrate")
    @Primary
    @FlywayDataSource
    public Flyway reflectionsFlyway() throws IOException {
        Flyway flyway = new Flyway();
        Properties properties = new Properties();
        flyway.setLocations("classpath:db/migration/reflections");
        flyway.configure(properties);
        flyway.setDataSource(reflectionsDataSource());
        return flyway;
    }
    
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

}
