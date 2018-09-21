package com.github.aha.poc.junit.spring;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public String getMessage() {
		return "Hello world!";	
	}
	
}
