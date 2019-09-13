package com.github.aha.poc.junit.springboot.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.aha.poc.junit.springboot.City;
import com.github.aha.poc.junit.springboot.CityRepository;

@ExtendWith(SpringExtension.class)
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
