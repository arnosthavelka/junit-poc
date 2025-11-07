package com.github.aha.poc.junit.springboot.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.github.aha.poc.junit.springboot.City;
import com.github.aha.poc.junit.springboot.CityController;
import com.github.aha.poc.junit.springboot.CityResource;
import com.github.aha.poc.junit.springboot.CityService;

@RestClientTest(CityController.class)
class CityControllerBeanTest {

	private static final long MADRID_ID = 5L;
	private static final String MADRID_NAME = "Madrid";

	@Autowired
	private CityController controller;

	@MockitoBean
	private CityService service;

	@Test
	void getItem() {
		// given
		when(this.service.getItem(MADRID_ID)).thenReturn(new City(MADRID_ID, MADRID_NAME));
		// when
		HttpEntity<CityResource> resource = this.controller.getItem(MADRID_ID);
		// then
		CityResource city = resource.getBody();
		assertThat(city.getId()).isEqualTo(MADRID_ID);
		assertThat(city.getName()).isEqualTo(MADRID_NAME);
	}

}
