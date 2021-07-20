package com.github.aha.poc.junit.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PersonServiceTests {

	@Test
	void shouldStoreEntity() {
		var person = new Person("Arny");

		assertThat(PersonService.store(person)).isEqualTo(person.getId());
	}

}