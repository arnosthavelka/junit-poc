package com.github.aha.poc.junit.spring;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
@DisplayName("Standard spring test for JUnit5")
public class StandardSpringTest {

	@Autowired
	HelloService service;
	
	@Test
	public void test() {
		assertThat(service, notNullValue());
		assertThat(service.getMessage(), is(equalTo("Hello world!")));
	}

}
