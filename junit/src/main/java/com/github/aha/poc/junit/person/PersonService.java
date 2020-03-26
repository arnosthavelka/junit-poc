package com.github.aha.poc.junit.person;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonService {

	public static int store(Person person) {
		// pretend to add person somewhere and return person's ID
		return person.getId();
	}

}
