package com.github.aha.poc.junit.springboot.rest;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.OK;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.github.aha.poc.junit.springboot.CityResource;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CityControllerIT {
	
    public static class ExtractResourcesType extends ParameterizedTypeReference<CollectionModel<CityResource>> {
    }

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void listCitiesWithRestTemplate() {
		ResponseEntity<CollectionModel<CityResource>> response = restTemplate.exchange("/cities/", GET, null, new ExtractResourcesType());
		assertThat(response.getStatusCode()).isEqualTo(OK);
//		assertThat(response.getBody().getContent().size()).isEqualTo(4);
	}

	@Test
	public void listCitiesWithRestAssured() {
		given()
		.when()
				.get("http://localhost:" + port + "/cities/")
		.then()
			.statusCode(200)
				.assertThat().body("_embedded.cityResources.size()", is(4));
	}

}
