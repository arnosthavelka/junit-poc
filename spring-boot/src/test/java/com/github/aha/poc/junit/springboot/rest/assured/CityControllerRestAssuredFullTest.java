package com.github.aha.poc.junit.springboot.rest.assured;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = MOCK)
@AutoConfigureMockMvc
public class CityControllerRestAssuredFullTest {

	private static final String ROOT_PATH = "/cities";
	private static final long PRAGUE_ID = 1L;
	private static final String PRAGUE_NAME = "Prague";

	@Autowired
	private MockMvc mvc;

	@Test
	@DisplayName("should read one city")
	void getCity() {
		given()
			.mockMvc(mvc)
		.when()
			.get(ROOT_PATH + "/{id}", PRAGUE_ID)
		.then()
			.statusCode(200)
			.assertThat().body("id", equalTo(1))
			.assertThat().body("name", equalTo(PRAGUE_NAME));
	}

}
