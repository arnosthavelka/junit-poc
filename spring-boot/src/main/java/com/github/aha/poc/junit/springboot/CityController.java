package com.github.aha.poc.junit.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HATEOAS is not used here, because it's not necessary (for this demo).
 * 
 * Usage:
 * <ul>
 * <li>search - http://localhost:8080/city/</li>
 * <li>detail - http://localhost:8080/city/2</li>
 * </ul>
 */
@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityService service;

	@GetMapping
	public List<City> list() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public City getItem(@PathVariable("id") Long id) {
		return service.getItem(id);
	}

}
