package com.github.aha.poc.junit.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest {

	@Test
	public void checkContext() {
		assertThat(true).isTrue();
	}

}
