package com.github.aha.poc.junit.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	HelloService service;

	/**
	 * Usage: localhost:8080/hello or http://localhost:8080/hello?name=Arny
	 * 
	 * @param name desired user's name
	 * @return greeting message
	 */
	@RequestMapping("/hello")
	public String getMessage(@RequestParam(value="name", required=false) String name) {
		return service.getMessage(name);
	}
	
}
