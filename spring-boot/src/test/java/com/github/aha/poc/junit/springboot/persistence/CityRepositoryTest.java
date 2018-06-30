package com.github.aha.poc.junit.springboot.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.aha.poc.junit.springboot.repository.CityRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CityRepositoryTest {

	@Autowired
	CityRepository repo;

	@Test
	public void testCount() {
		assertThat(repo.count()).isEqualTo(4);
	}

}
