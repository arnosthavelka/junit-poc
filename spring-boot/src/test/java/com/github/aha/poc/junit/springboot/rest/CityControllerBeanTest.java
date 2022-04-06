package com.github.aha.poc.junit.springboot.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.aha.poc.junit.springboot.City;
import com.github.aha.poc.junit.springboot.CityController;
import com.github.aha.poc.junit.springboot.CityResource;
import com.github.aha.poc.junit.springboot.CityService;

@ExtendWith(SpringExtension.class)
@RestClientTest(CityController.class)
public class CityControllerBeanTest {

	private static final long MADRID_ID = 5L;
	private static final String MADRID_NAME = "Madrid";

	@Autowired
	private CityController controller;

	@MockBean
	private CityService service;

	@Test
	public void getItem() {
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
