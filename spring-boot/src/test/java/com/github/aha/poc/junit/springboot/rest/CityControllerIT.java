package com.github.aha.poc.junit.springboot.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestClient;

import com.github.aha.poc.junit.springboot.CityResource;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureRestTestClient
class CityControllerIT {

	private static final String ROOT_PATH = "/cities";

	@Autowired
	RestClient.Builder builder;

	@LocalServerPort
	private int port;

	@Nested
	class ListCities {

		static final String EXPECTED_JSON_RESPONSE = """
				{"_embedded":{"cityResources":[{"country":"Czech Republic","id":1,"name":"Prague"},{"country":"Great Britain","id":2,"name":"London"},{"country":"France","id":3,"name":"Paris"},{"country":"Germany","id":4,"name":"Berlin"}]}}
				"""
				.trim();
		RestClient restClient = builder.baseUrl("http://localhost:" + port).build();

		@Test
		void retrieve() {
			var response = restClient.get().uri(ROOT_PATH).accept(APPLICATION_JSON).retrieve().body(String.class);

			assertThat(response).isEqualTo(EXPECTED_JSON_RESPONSE);
		}

		@Test
		void exchange() {
			String response = restClient.get().uri(ROOT_PATH).accept(APPLICATION_JSON).exchange((request, clientResponse) -> {
				if (clientResponse.getStatusCode().is2xxSuccessful()) {
					return clientResponse.bodyTo(String.class);
				} else {
					throw new RuntimeException("Unexpected status: " + clientResponse.getStatusCode());
				}
			});

			assertThat(response).isEqualTo(EXPECTED_JSON_RESPONSE);
		}

	}

	@Test
	void getCity() {
		long cityId = 3;

		RestClient restClient = builder.baseUrl("http://localhost:" + port).build();
		var response = restClient.get().uri(ROOT_PATH + "/" + cityId).accept(APPLICATION_JSON).retrieve().toEntity(CityResource.class);

		assertThat(response.getStatusCode()).isEqualTo(OK);
		assertThat(response.getBody()).satisfies(city -> {
			assertThat(city.getId()).isEqualTo(cityId);
			assertThat(city.getName()).isEqualTo("Paris");
			assertThat(city.getCountry()).isEqualTo("France");
		});
	}

}
