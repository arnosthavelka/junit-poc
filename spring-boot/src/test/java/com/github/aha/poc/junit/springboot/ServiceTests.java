package com.github.aha.poc.junit.springboot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {

	@Autowired
	HelloService service;
	
	@Test
	public void helloAnonymous() {
		assertThat(service.getMessage(null), is(equalTo("Hello Unknown user!")));
	}

	@Test
	public void helloArny() {
		assertThat(service.getMessage("Arny"), is(equalTo("Hello Arny!")));
	}

}
