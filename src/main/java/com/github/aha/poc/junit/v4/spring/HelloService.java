package com.github.aha.poc.junit.v4.spring;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public String getMessage() {
		return "Hello world!";	
	}
	
}
