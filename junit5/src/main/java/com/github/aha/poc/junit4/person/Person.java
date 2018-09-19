package com.github.aha.poc.junit4.person;

public final class Person {
	
	private int id;
	
	private String name;

	public Person(String name) {
		super();
		this.id = SequenceGenerator.nextId();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
