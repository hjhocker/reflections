package com.harrison.config;

import java.io.IOException;

import javax.sql.DataSource;

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

}
