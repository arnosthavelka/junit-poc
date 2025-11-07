package com.github.aha.poc.junit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes=SpringConfig.class)
@DisplayName("Simple spring test for JUnit5")
class SimpleSpringTest {

	@Autowired
	HelloService service;
	
	@Test
	void getMessage() {
		assertThat(service.getMessage()).isEqualTo("Hello world!");
	}

}
