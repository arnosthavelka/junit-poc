package com.github.aha.poc.junit.springboot.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.OK;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.github.aha.poc.junit.springboot.CityResource;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureTestRestTemplate // TODO switch to @AutoConfigureWebTestClient?
class CityControllerIT {
	
	private static final String ROOT_PATH = "/cities";

	static class ExtractParameterizedResources
			extends ParameterizedTypeReference<CollectionModel<CityResource>> {
	}

	static class ExtractResources extends CollectionModel<CityResource> {
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	void listCitiesWithGet() {
		ResponseEntity<ExtractResources> response = restTemplate.getForEntity(ROOT_PATH, ExtractResources.class);
		assertThat(response.getStatusCode()).isEqualTo(OK);
		assertThat(response.getBody().getContent()).hasSize(4);
	}

	@Test
	void listCitiesWithExchange() {
		ResponseEntity<CollectionModel<CityResource>> response = restTemplate.exchange(ROOT_PATH, GET, null,
				new ExtractParameterizedResources());
		assertThat(response.getStatusCode()).isEqualTo(OK);
		assertThat(response.getBody().getContent()).hasSize(4);
	}

	@Test
	void getCity() {
		long cityId = 3;
		ResponseEntity<CityResource> response = restTemplate.getForEntity(ROOT_PATH + "/" + cityId, CityResource.class);

		assertThat(response.getStatusCode()).isEqualTo(OK);
		CityResource city = response.getBody();
		assertThat(city.getId()).isEqualTo(cityId);
		assertThat(city.getName()).isEqualTo("Paris");
		assertThat(city.getCountry()).isEqualTo("France");
	}

}
