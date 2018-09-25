package com.github.aha.poc.junit.springboot;

public class CityResource {

	public CityResource(City entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.country = entity.getCountry();
	}

	private Long id;

	private String name;

	private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
