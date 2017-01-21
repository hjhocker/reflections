package com.harrison.config;

import org.reflections.Reflections;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ReflectionConfig {

	@Bean
	public Reflections reflections() {
		return new Reflections("com.harrison");
	}
	
}
