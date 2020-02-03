package com.github.aha.poc.junit.springboot;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CityResource {

	public CityResource(City entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.country = entity.getCountry();
	}

	private Long id;

	private String name;

	private String country;

}
