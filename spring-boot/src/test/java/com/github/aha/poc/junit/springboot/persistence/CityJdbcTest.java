package com.github.aha.poc.junit.springboot.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest(webEnvironment = NONE)
public class CityJdbcTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	public void testCount() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from city", Integer.class);
		assertThat(count).isEqualTo(4);
	}

}
