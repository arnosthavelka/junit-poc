package com.github.aha.poc.junit.person;

import lombok.Getter;

@Getter
public final class Person {

	private int id;

	private String name;

	public Person(String name) {
		this.id = SequenceGenerator.nextId();
		this.name = name;
	}

}
