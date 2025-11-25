package com.github.aha.poc.junit.springboot;

import static org.springframework.hateoas.CollectionModel.of;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * Usage:
 * <ul>
 * <li>search - http://localhost:8080/cities</li>
 * <li>detail - http://localhost:8080/cities/2</li>
 * </ul>
 */
@RestController
@RequestMapping(value = "/cities", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CityController {

	private final CityService service;

	@GetMapping
	public HttpEntity<CollectionModel<CityResource>> list() {
		List<City> result = service.getAll();
		return ok(of(toResources(result)));
	}

	@GetMapping("/{id}")
	public HttpEntity<CityResource> getItem(@PathVariable("id") Long id) {
		City result = service.getItem(id);
		return ok(mapEntity(result));
	}

	static List<CityResource> toResources(List<City> result) {
		return result.stream().map(CityController::mapEntity).toList();
	}

	static CityResource mapEntity(City city) {
		return new CityResource(city);
	}
}
