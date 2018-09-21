package com.github.aha.poc.junit5.params;

public class Drink {

	private String name;
	private Integer price;

	public Drink(String name, Integer price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}

}
