package com.github.aha.poc.junit.spring;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	private static final String HELLO_MESSAGE = "Hello world!";

	public String getMessage() {
		return HELLO_MESSAGE;	
	}
	
}
