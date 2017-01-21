package com.harrison.config;

import org.reflections.Reflections;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ReflectionConfig {

	private static final String COM_HARRISON = "com.harrison";

	@Bean
	public Reflections reflections() {
		return new Reflections(COM_HARRISON);
	}
	
}
