package com.harrison.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

@Component
public class EmbeddedPostgresConfig {

	@Bean
	public DataSource dataSource() throws IOException {
		EmbeddedPostgres pg = EmbeddedPostgres.builder().setPort(15432).start();
		return pg.getPostgresDatabase();
	}
	

	
}
