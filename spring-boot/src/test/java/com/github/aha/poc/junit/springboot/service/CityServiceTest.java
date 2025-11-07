package com.github.aha.poc.junit.springboot.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.github.aha.poc.junit.springboot.City;
import com.github.aha.poc.junit.springboot.CityRepository;
import com.github.aha.poc.junit.springboot.CityService;

@SpringBootTest(webEnvironment = NONE)
class CityServiceTest {

	private static final long PRAGUE_ID = 1L;
	private static final String PRAGUE_NAME = "Prague";

	@Autowired
	CityService service;

	@MockitoBean
	CityRepository repo;

	@Test
	void testMadridCity() {
		// given
		when(this.repo.findById(PRAGUE_ID)).thenReturn(Optional.of(new City(5L, PRAGUE_NAME)));
		// when
		City city = this.service.getItem(PRAGUE_ID);
		// then
		assertThat(city.getName()).isEqualTo(PRAGUE_NAME);
	}
}
