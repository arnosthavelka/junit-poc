package com.github.aha.poc.junit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(initializers = InitializerTest.Initializer.class)
@DisplayName("Initialize context manually")
public class InitializerTest {

	@Autowired
	HelloService service;

	@Test
	public void getMessage() {
		assertThat(service.getMessage()).isEqualTo("Hello world!");
	}

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

		@Override
		public void initialize(ConfigurableApplicationContext context) {
			context.getBeanFactory().registerSingleton("helloService", new HelloService());
		}

	}

}
