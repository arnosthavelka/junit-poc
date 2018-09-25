package com.github.aha.poc.junit.person;

public class PersonService {

	private PersonService() {
		// hide constructor
	}

	public static int store(Person person) {
		// pretend to add person somewhere and return person's ID
		return person.getId();
	}

}
