package com.github.aha.poc.junit.springboot.rest.assured;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.github.aha.poc.junit.springboot.City;
import com.github.aha.poc.junit.springboot.CityController;
import com.github.aha.poc.junit.springboot.CityService;

@SpringBootTest(webEnvironment = MOCK, classes = CityController.class)
public class CityControllerRestAssuredControllerTest {

	private static final String ROOT_PATH = "/cities";
	private static final long PRAGUE_ID = 1L;

	@MockBean
	CityService service;

	@Autowired
	CityController controller;

	@Test
	@DisplayName("should read one city")
	void getCity() {
		when(service.getItem(PRAGUE_ID)).thenReturn(buildCity(999L, "Tokyo"));
		given()
			.standaloneSetup(controller)
		.when()
			.get(ROOT_PATH + "/{id}", PRAGUE_ID)
		.then()
			.statusCode(200)
			.assertThat().header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
			.assertThat().content(
					"id", equalTo(999),
					"name", equalTo("Tokyo"));
	}

	@Test
	@DisplayName("should list cities")
	void listCities() {
		List<City> cities = asList(buildCity(111L, "Prague"), buildCity(222L, "Madrid"), buildCity(999L, "Tokyo"));
		when(service.getAll()).thenReturn(cities);
		given()
			.standaloneSetup(controller)
		.when()
			.get(ROOT_PATH + "")
		.then()
			.statusCode(200)
			.assertThat().header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
			// {"links":[],"content":[{"id":111,"name":"Prague","country":null},{"id":222,"name":"Madrid","country":null},{"id":999,"name":"Tokyo","country":null}]}
			.assertThat().body("content.size()", is(3))
			.assertThat().body("content[2].id", equalTo(999))
			.assertThat().body("content[2].name", equalTo("Tokyo"));

//		MockMvcResponse response = given()
//				.extract().response();
//		CityResource[] content = response.getBody().as(CityResource[].class);
		assertThat(3).isEqualTo(3);
//			.assertThat().body("size()", is(2));
//			.assertThat().body("_embedded.cityResourceList.id", equalTo(999))
//			.assertThat().body("_embedded.cityResourceList.name", equalTo("Tokyo"));
	}

	private City buildCity(Long id, String name) {
		return new City(id, name);
	}
}
