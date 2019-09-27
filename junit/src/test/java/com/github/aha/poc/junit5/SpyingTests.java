package com.github.aha.poc.junit5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import lombok.extern.slf4j.Slf4j;

// based on https://blog.jdriven.com/2013/05/mock-superclass-method-with-mockito/
@DisplayName("Examples of spying tests")
@Slf4j
public class SpyingTests {

	@Test
	@DisplayName("should mock inherited method in spied class")
	void mockInheritedMethod() {
		HelloService spy = Mockito.spy(new HelloService());
		Mockito.doNothing().when((HelloService) spy).logStart();

		assertThat(spy.sayGreeting()).isEqualTo("Hello");
	}

	abstract class GreetingService {

		public String sayGreeting() {
			logStart();
			return getGreeting();
		}

		protected abstract String getGreeting();

		void logStart() {
			log.info("starting greeting");
		}
	}

	class HelloService extends GreetingService {

		@Override
		protected String getGreeting() {
			return "Hello";
		}

	}
}
