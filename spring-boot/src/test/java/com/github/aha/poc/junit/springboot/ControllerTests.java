package com.github.aha.poc.junit.springboot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@RestClientTest(HelloController.class)
public class ControllerTests {

	@Autowired
	private HelloController controller;

	@MockBean
	private HelloService service;
	
	@Test
	public void helloAnonymous() {
		final String name = null; // not defined
		final String expectedResponse = "Hello Unknown user!";
		testController(name, expectedResponse);
	}

	@Test
	public void helloArny() {
		final String name = "Helga";
		final String expectedResponse = "Hello Helga!";
		testController(name, expectedResponse);
	}

	private void testController(final String name, String expectedResponse) {
		// prepare service response
		when(this.service.getMessage(name)).thenReturn(expectedResponse);
		// start controller
		String response = this.controller.getMessage(name);
		// verify response		
		assertThat(response, equalTo(expectedResponse));
	}

}
