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
public class ControllerTests {

	@Autowired
	HelloController controller;
	
	@Test
	public void helloAnonymous() {
		assertThat(controller.getMessage(null), is(equalTo("Hello Unknown user!")));
	}

	@Test
	public void helloArny() {
		assertThat(controller.getMessage("Arny"), is(equalTo("Hello Arny!")));
	}

}
