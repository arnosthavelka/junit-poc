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
 * @see http://localhost:8080/city/
 * @see http://localhost:8080/city/2
 */
@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityService service;

	/**
	 * Usage: localhost:8080/hello or http://localhost:8080/hello?name=Arny
	 * 
	 * @param name desired user's name
	 * @return greeting message
	 */
	@GetMapping("/")
	public List<City> list() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public City item(@PathVariable("id") Long id) {
		return service.getItem(id);
	}

}
