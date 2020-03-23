package com.github.aha.poc.junit.springboot;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.webAppContextSetup;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = MOCK)
public abstract class AbstractContractTest {

	@Autowired
	private WebApplicationContext context;

	@BeforeEach
	void setup() {
		webAppContextSetup(context);
	}
}
