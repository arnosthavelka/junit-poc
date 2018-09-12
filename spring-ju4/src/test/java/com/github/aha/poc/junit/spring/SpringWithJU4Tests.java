package com.github.aha.poc.junit.spring;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=SpringConfig.class)
public class SpringWithJU4Tests {

	@Autowired
	HelloService service;
	
	@Test
	public void test() {
		assertThat(service, notNullValue());
		assertThat(service.getMessage(), is(equalTo("Hello world!")));
	}

}
