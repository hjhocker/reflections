package com.harrison.scan;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class ReflectionStuff {

	@Autowired
	private Reflections reflections;
	
	@PostConstruct
	public void search() {
		System.out.println("*********************************************");
		Set<Class<?>> controllers = reflections.getTypesAnnotatedWith(RestController.class);
		for (Class<?> controller : controllers) {
			System.out.println("##########################" + controller.getName());
		}
	}
	
}
