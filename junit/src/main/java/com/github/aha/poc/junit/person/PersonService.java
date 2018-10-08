package com.github.aha.poc.junit.person;

import static lombok.AccessLevel.PRIVATE;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class PersonService {

	public static int store(Person person) {
		// pretend to add person somewhere and return person's ID
		return person.getId();
	}

}
