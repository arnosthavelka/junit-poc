package com.github.aha.poc.junit.springboot.rest.assured;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = MOCK)
@AutoConfigureMockMvc
public class CityControllerRestAssuredMvcTest {

	private static final String ROOT_PATH = "/cities";
	private static final Long PRAGUE_ID = 1L;
	private static final String PRAGUE_NAME = "Prague";

	@Autowired
	private MockMvc mvc;
	
	@Test
	@DisplayName("should read one city")
	void getCity() {
		given()
			.mockMvc(mvc)
		.when()
			.get(ROOT_PATH + "/{id}", PRAGUE_ID.toString())
		.then()
			.statusCode(200)
			.assertThat().body("id", equalTo(1))
			.assertThat().body("name", equalTo(PRAGUE_NAME));
	}

	@Test
	@DisplayName("should list cities")
	void listCities() {
		given()
			.mockMvc(mvc)
			.log().all()
		.when()
			.get(ROOT_PATH)
		.then()
			.log().body()
			.statusCode(200)
			.assertThat().header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
			.assertThat().body(
						"_embedded.cityResources.size()", is(4),
						"_embedded.cityResources[2].id", equalTo(3),
						"_embedded.cityResources[2].name", equalTo("Paris"),
						"_embedded.cityResources[2].country", equalTo("France"));

	}

	@Test
	@DisplayName("should run list cities under 1s")
	void measurePerformanceOfListCities() {
		given()
			.mockMvc(mvc)
		.when()
			.get(ROOT_PATH)
		.then()
			.time(lessThan(1L), SECONDS);

	}
}
