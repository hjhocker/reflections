package com.harrison.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

@Component
@EnableJpaRepositories(
        basePackages = "com.harrison.suggestedskills.repository")
@Profile("local")
public class LocalSuggestedSkillsConfig {

    @Bean(name = "suggestedSkillsDataSource")
    @FlywayDataSource
    public DataSource suggestedSkillsDataSource() throws IOException {
        return EmbeddedPostgres
                .builder()
                .setPort(15433)
                .start()
                .getPostgresDatabase();
    }
    
    @Bean(initMethod = "migrate")
    @FlywayDataSource
    public Flyway flyway() throws IOException {
        Flyway flyway = new Flyway();
        Properties properties = new Properties();
        flyway.configure(properties);
        flyway.setLocations("classpath:db/migration/suggestedskills");
        flyway.setDataSource(suggestedSkillsDataSource());
        return flyway;
    }

}
