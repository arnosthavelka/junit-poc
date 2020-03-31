package com.github.aha.poc.junit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes=SpringConfig.class)
@DisplayName("Setting properties for test purposes")
public class PropertiesTest {

	private static final String ENVIRONMENT_KEY = "ju5.spring.test.environment";
	private static final String ENVIRONMENT_MEM = "MEM";

	@Autowired
	Environment environment;

	@DynamicPropertySource
	static void initProperties(DynamicPropertyRegistry registry) {
		registry.add(ENVIRONMENT_KEY, () -> ENVIRONMENT_MEM);
	}
	
	@Test
	public void test() {
		assertThat(environment.getProperty(ENVIRONMENT_KEY)).isEqualTo(ENVIRONMENT_MEM);
	}

}
