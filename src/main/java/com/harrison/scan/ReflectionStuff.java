package com.harrison.scan;

import java.lang.reflect.Method;
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
			Method[] methods = controller.getMethods();
			System.out.println(methods[0].getParameters()[0].getName());
			System.out.println(methods[0].getParameterCount());
			System.out.println(methods[0].getName());
			System.out.println(methods[0].getParameterTypes()[0].getSimpleName());
			System.out.println(methods[0].getParameterTypes()[0].getCanonicalName());
			System.out.println(methods[0].getParameterTypes()[0].getName());
			System.out.println(methods[0].getParameterTypes()[0].getTypeName());
			System.out.println(methods[0].getParameters()[0].getName());
			System.out.println(methods[0].getReturnType().getSimpleName());
		}
	}

}
