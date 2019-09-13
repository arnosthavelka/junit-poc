package com.github.aha.poc.junit.springboot.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.aha.poc.junit.springboot.City;
import com.github.aha.poc.junit.springboot.CityRepository;
import com.github.aha.poc.junit.springboot.CityService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = NONE)
public class CityServiceTest {

	private static final long PRAGUE_ID = 1L;
	private static final String PRAGUE_NAME = "Prague";

	@Autowired
	CityService service;

	@MockBean
	CityRepository repo;

	@Test
	public void testMadridCity() {
		// given
		when(this.repo.findById(PRAGUE_ID)).thenReturn(Optional.of(new City(5L, PRAGUE_NAME)));
		// when
		City city = this.service.getItem(PRAGUE_ID);
		// then
		assertThat(city.getName()).isEqualTo(PRAGUE_NAME);
	}
}
