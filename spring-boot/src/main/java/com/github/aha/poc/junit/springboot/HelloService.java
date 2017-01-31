package com.github.aha.poc.junit.springboot;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HelloService {

	public String getMessage(String name) {
		if (StringUtils.isEmpty(name)) {
			name = "Unknown user";
		}		
		return String.format("Hello %s!", name);		
	}
	
}
