package com.github.aha.poc.junit.springboot.rest;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.hateoas.MediaTypes.HAL_JSON;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;
import org.springframework.hateoas.server.mvc.TypeConstrainedMappingJackson2HttpMessageConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.aha.poc.junit.springboot.CityResource;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CityControllerIT {
	
	public static class ExtractParameterizedResources extends ParameterizedTypeReference<CollectionModel<CityResource>> {
	}

	public static class ExtractResources extends CollectionModel<CityResource> {
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@PostConstruct
	private void init() {
		List<HttpMessageConverter<?>> existingConverters = restTemplate.getRestTemplate().getMessageConverters();
		List<HttpMessageConverter<?>> newConverters = new ArrayList<>();
		// register HAL converter
		newConverters.add(getHalMessageConverter());
		newConverters.addAll(existingConverters);
		restTemplate.getRestTemplate().setMessageConverters(newConverters);
	}

	private HttpMessageConverter<?> getHalMessageConverter() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new Jackson2HalModule());
		MappingJackson2HttpMessageConverter halConverter = new TypeConstrainedMappingJackson2HttpMessageConverter(RepresentationModel.class);
		halConverter.setSupportedMediaTypes(of(HAL_JSON, APPLICATION_JSON));
		halConverter.setObjectMapper(objectMapper);
		return halConverter;
	}

	@Test
	public void listCitiesWithGet() {
		ResponseEntity<ExtractResources> response = restTemplate.getForEntity("/cities/", ExtractResources.class);
		assertThat(response.getStatusCode()).isEqualTo(OK);
		assertThat(response.getBody().getContent().size()).isEqualTo(4);
	}

	@Test
	public void listCitiesWithExchange() {
		ResponseEntity<CollectionModel<CityResource>> response = restTemplate.exchange("/cities/", GET,
				null, new ExtractParameterizedResources());
		assertThat(response.getStatusCode()).isEqualTo(OK);
		assertThat(response.getBody().getContent().size()).isEqualTo(4);
	}

	@Test
	public void getCity() {
		long cityId = 3;
		ResponseEntity<CityResource> response = restTemplate.getForEntity("/cities/" + cityId, CityResource.class);

		assertThat(response.getStatusCode()).isEqualTo(OK);
		CityResource city = response.getBody();
		assertThat(city.getId()).isEqualTo(cityId);
		assertThat(city.getName()).isEqualTo("Paris");
		assertThat(city.getCountry()).isEqualTo("France");
	}

}
