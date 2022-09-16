package com.github.aha.poc.junit.springboot.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.aha.poc.junit.springboot.City;
import com.github.aha.poc.junit.springboot.CityRepository;

@DataJpaTest
public class CityRepositoryTest {

	@Autowired
	CityRepository repo;

	@Test
	public void countEntities() {
		assertThat(repo.count()).isEqualTo(4);
	}

	@Test
	public void findEntity() {
		Optional<City> entityRef = repo.findByName("Prague");
		assertThat(entityRef.get().getCountry()).isEqualTo("Czech Republic");
	}

}
