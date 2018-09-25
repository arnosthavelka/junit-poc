package com.github.aha.poc.junit.springboot;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Usage:
 * <ul>
 * <li>search - http://localhost:8080/cities/</li>
 * <li>detail - http://localhost:8080/cities/2</li>
 * </ul>
 */
@RestController
@RequestMapping(value = "/cities", produces = APPLICATION_JSON_VALUE)
public class CityController {

	@Autowired
	CityService service;

	@GetMapping
	public HttpEntity<Resources<CityResource>> list() {
		List<City> result = service.getAll();
		return new ResponseEntity<>(new Resources<>(toResources(result)), OK);
	}

	@GetMapping("/{id}")
	public HttpEntity<CityResource> getItem(@PathVariable("id") Long id) {
		City result = service.getItem(id);
		return new ResponseEntity<>(mapEntity(result), OK);
	}

	private List<CityResource> toResources(List<City> result) {
		return result.stream().map(CityController::mapEntity).collect(toList());
	}

	static CityResource mapEntity(City city) {
		return new CityResource(city);
	}
}
