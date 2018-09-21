package com.github.aha.poc.junit5.intro;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("Usage of assumes in JUnit5")
public class AssumeTests {

	private static final Logger LOG = LoggerFactory.getLogger(AssumeTests.class);
	
	private static final String OS_KEY = "OS";
	private static final String OS_WIN = "Windows_NT";
	private static final String JAVA_KEY = "java.version";
	private static final String JAVA8 = "1.8";
	
	@Test
	@DisplayName("validate environment")
	void validateEnvironment() {
		assumeTrue(OS_WIN.equals(System.getenv(OS_KEY)));
		assumingThat(System.getProperty(JAVA_KEY).startsWith(JAVA8),
	            () -> {
	                // perform these assertions only on the CI server
	            	System.getProperties().entrySet().stream().limit(5).forEach(entry -> 
	            		LOG.info("{}={}", entry.getKey(), entry.getValue()));
	            });
	}
}
