package com.github.aha.poc.junit.spring;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.aha.poc.junit.spring.HelloService;
import com.github.aha.poc.junit.spring.SpringConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=SpringConfig.class)
public class SpringTests {

	@Autowired
	HelloService service;
	
	@Test
	public void test() {
		assertThat(service.getMessage(), is(equalTo("Hello world!")));
	}

}
