package com.github.aha.poc.junit.springboot.rest.assured;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.github.aha.poc.junit.springboot.City;
import com.github.aha.poc.junit.springboot.CityController;
import com.github.aha.poc.junit.springboot.CityResource;
import com.github.aha.poc.junit.springboot.CityService;

import io.restassured.module.mockmvc.response.MockMvcResponse;
import io.restassured.response.ExtractableResponse;

@SpringBootTest(webEnvironment = MOCK, classes = CityController.class)
class CityControllerRestAssuredControllerTest {

	private static final String ROOT_PATH = "/cities";
	private static final Long PRAGUE_ID = 1L;

	@MockitoBean
	CityService service;

	@Autowired
	CityController controller;

	@Test
	void getCityDetail() {
		when(service.getItem(PRAGUE_ID)).thenReturn(buildCity(999L, "Tokyo"));
		given()
			.standaloneSetup(controller)
			.pathParam("id", PRAGUE_ID)
		.when()
			.get(ROOT_PATH + "/{id}")
		.then()
			.statusCode(200)
				.assertThat().header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
				.assertThat().body(
					"id", equalTo(999),
					"name", equalTo("Tokyo"));
	}

	@Test
	void getCityDetailAndRetriveCompleteResponse() {
		when(service.getItem(PRAGUE_ID)).thenReturn(buildCity(123L, "Moscow"));
		ExtractableResponse<MockMvcResponse> response =
		given()
			.standaloneSetup(controller)
			.pathParam("id", PRAGUE_ID)
		.when()
			.get(ROOT_PATH + "/{id}")
		.then()
			.extract();

		assertThat(response.statusCode()).isEqualTo(OK.value());
		assertThat(response.header(CONTENT_TYPE)).isEqualTo(APPLICATION_JSON_VALUE);
		CityResource cityResource = response.body().as(CityResource.class);
		assertThat(cityResource.getId()).isEqualTo(123);
		assertThat(cityResource.getName()).isEqualTo("Moscow");
	}
	
	@Test
	void getCityDetailAndRetriveDirectCity() {
		when(service.getItem(PRAGUE_ID)).thenReturn(buildCity(456L, "Sydney"));

		CityResource cityResource = given()
			.standaloneSetup(controller)
			.pathParam("id", PRAGUE_ID)
		.when()
			.get(ROOT_PATH + "/{id}")
		.then()
			.extract().as(CityResource.class);

		assertThat(cityResource.getId()).isEqualTo(456);
		assertThat(cityResource.getName()).isEqualTo("Sydney");
	}
	
	@Test
	void listCitiesWithout() {
		List<City> cities = asList(buildCity(111L, "Prague"), buildCity(222L, "Madrid"), buildCity(999L, "Tokyo"));
		when(service.getAll()).thenReturn(cities);
		given()
			.standaloneSetup(controller)
		.when()
			.get(ROOT_PATH)
		.then()
			.log().body()
			.statusCode(200)
			.assertThat().header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
			.assertThat().body("content.size()", is(3))
			.assertThat().body("content[2].id", equalTo(999))
			.assertThat().body("content[2].name", equalTo("Tokyo"));

	}

	static City buildCity(Long id, String name) {
		return new City(id, name);
	}

}
