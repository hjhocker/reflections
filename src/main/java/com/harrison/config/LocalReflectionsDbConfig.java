package com.harrison.config;

import java.io.IOException;

import javax.sql.DataSource;

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
