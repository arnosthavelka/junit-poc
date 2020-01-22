package com.github.aha.poc.junit.springboot.rest.assured;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
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

	@Test
	@DisplayName("should list cities")
	void listCities() {
		given()
			.mockMvc(mvc)
		.when()
			.get(ROOT_PATH + "")
		.then()
		/* expected response: 
		 {
		 	"_embedded":{
		 		"cityResourceList":[
		 			{"id":1,"name":"Prague","country":"Czech Republic"},
		 			{"id":2,"name":"London","country":"Great Britain"},
		 			{"id":3,"name":"Paris","country":"France"},
		 			{"id":4,"name":"Berlin","country":"Germany"}
	 			]
 			}
		} */
			.statusCode(200)
			.assertThat().header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
			.assertThat().body(
						"_embedded.cityResourceList.size()", is(4),
						"_embedded.cityResourceList[2].id", equalTo(3),
						"_embedded.cityResourceList[2].name", equalTo("Paris"),
						"_embedded.cityResourceList[2].country", equalTo("France"));

	}
}
