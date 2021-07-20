package com.github.aha.poc.junit.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PersonTests {

	@Test
	void shouldGenerateId() {
		var lastId = SequenceGenerator.nextId();

		Person person = new Person("Arny");

		assertThat(person.getId()).isGreaterThan(lastId);
	}

}