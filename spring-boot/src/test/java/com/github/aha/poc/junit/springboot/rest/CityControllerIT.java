package com.github.aha.poc.junit.springboot.rest;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.hateoas.MediaTypes.HAL_JSON;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.OK;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
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

	@Test
	public void listCitiesWithGet() {
		ResponseEntity<ExtractResources> response = restTemplate.getForEntity("/cities/", ExtractResources.class);
		assertThat(response.getStatusCode()).isEqualTo(OK);
//		assertThat(response.getBody().getContent().size()).isEqualTo(4);
	}

	@Test
	public void listCitiesWithExchange() {
		ResponseEntity<CollectionModel<CityResource>> response = buildHalTemplate().exchange("/cities/", GET, null,
				new ExtractParameterizedResources());
		assertThat(response.getStatusCode()).isEqualTo(OK);
//		assertThat(response.getBody().getContent().size()).isEqualTo(4);
	}

	public TestRestTemplate buildHalTemplate() {
		List<HttpMessageConverter<?>> existingConverters = restTemplate.getRestTemplate().getMessageConverters();
		List<HttpMessageConverter<?>> newConverters = new ArrayList<>();
		newConverters.add(getHalMessageConverter());
		newConverters.addAll(existingConverters);
		restTemplate.getRestTemplate().setMessageConverters(newConverters);
		return restTemplate;
	}

	private HttpMessageConverter<?> getHalMessageConverter() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new Jackson2HalModule());
		MappingJackson2HttpMessageConverter halConverter = new TypeConstrainedMappingJackson2HttpMessageConverter(RepresentationModel.class);
		halConverter.setSupportedMediaTypes(of(HAL_JSON));
		halConverter.setObjectMapper(objectMapper);
		return halConverter;
	}

}
