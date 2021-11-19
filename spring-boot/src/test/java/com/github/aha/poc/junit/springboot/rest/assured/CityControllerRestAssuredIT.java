package com.github.aha.poc.junit.springboot.rest.assured;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import com.github.aha.poc.junit.springboot.CityResource;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CityControllerRestAssuredIT {
	
	@LocalServerPort
	private int port;

	@Test
	public void listCities() {
		when()
			.get("http://localhost:" + port + "/cities/")
		.then()
			.statusCode(200)
			.assertThat().body(
					"_embedded.cityResources.size()", is(4),
					"_embedded.cityResources[2].id", equalTo(3),
					"_embedded.cityResources[2].name", equalTo("Paris"));
	}

	@Test
	public void getCity() {
		long cityId = 2L;
		CityResource city = get("http://localhost:" + port + "/cities/" + cityId).then().extract().as(CityResource.class);
		assertThat(city.getId()).isEqualTo(cityId);
		assertThat(city.getName()).isEqualTo("London");
		assertThat(city.getCountry()).isEqualTo("Great Britain");
	}

}
