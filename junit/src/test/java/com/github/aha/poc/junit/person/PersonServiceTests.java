package com.github.aha.poc.junit.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PersonServiceTests {

	@Test
	void getId() {
		var currentValue = SequenceGenerator.nextId();

		assertThat(new Person("Arny").getId()).isEqualTo(currentValue + 1);
	}


}