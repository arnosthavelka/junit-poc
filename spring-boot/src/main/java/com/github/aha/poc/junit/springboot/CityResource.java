package com.github.aha.poc.junit.springboot;

import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Relation(collectionRelation = "cityResources")
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
