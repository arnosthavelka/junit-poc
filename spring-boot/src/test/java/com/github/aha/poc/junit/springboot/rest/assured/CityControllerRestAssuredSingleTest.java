package com.github.aha.poc.junit.springboot.rest.assured;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.github.aha.poc.junit.springboot.City;
import com.github.aha.poc.junit.springboot.CityController;
import com.github.aha.poc.junit.springboot.CityService;

@SpringBootTest(webEnvironment = MOCK, classes = CityController.class)
public class CityControllerRestAssuredSingleTest {

	private static final String ROOT_PATH = "/cities";
	private static final long PRAGUE_ID = 1L;

	@MockBean
	CityService service;

	@Autowired
	CityController controller;

	@Test
	@DisplayName("should read one city")
	void getCity() {
		when(service.getItem(PRAGUE_ID)).thenReturn(new City(999L, "Tokyo"));
		given()
			.standaloneSetup(controller)
		.when()
			.get(ROOT_PATH + "/{id}", PRAGUE_ID)
		.then()
			.statusCode(200)
			.assertThat().body("id", equalTo(999))
			.assertThat().body("name", equalTo("Tokyo"));
	}

}
