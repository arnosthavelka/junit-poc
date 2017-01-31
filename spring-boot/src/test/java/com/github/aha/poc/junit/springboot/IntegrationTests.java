package com.github.aha.poc.junit.springboot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class IntegrationTests {

	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	public void helloAnonymous() {
		String msg = restTemplate.getForObject("/hello", String.class);
		assertThat(msg, is(equalTo("Hello Unknown user!")));
	}

	@Test
	public void helloArny() {
		String msg = restTemplate.getForObject("/hello?name={id}", String.class, "Arny");
		assertThat(msg, is(equalTo("Hello Arny!")));
	}

}
