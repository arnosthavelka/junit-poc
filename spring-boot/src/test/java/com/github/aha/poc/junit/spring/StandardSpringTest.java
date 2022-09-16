package com.github.aha.poc.junit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
public class StandardSpringTest {

	@Autowired
	HelloService service;
	
	@Test
	public void test() {
		assertThat(service).isNotNull();
		assertThat(service.getMessage()).isEqualTo("Hello world!");
	}

}
