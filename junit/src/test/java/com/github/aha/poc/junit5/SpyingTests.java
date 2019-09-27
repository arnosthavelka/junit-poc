package com.github.aha.poc.junit5;

import static com.github.aha.poc.junit5.SpyingTests.GreetingService.WELCOME;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// based on https://blog.jdriven.com/2013/05/mock-superclass-method-with-mockito/
@DisplayName("Examples of spying tests")
public class SpyingTests {

	@Test
	@DisplayName("should mock inherited method in spied class")
	void regularUsage() {
		HelloService service = new HelloService();

		assertThat(service.sayGreeting()).isEqualTo("Welcome and Hello");
		assertThat(service.generalGreeting).isEqualTo(WELCOME);
	}

	@Test
	@DisplayName("should mock inherited method in spied class")
	void mockInheritedMethod() {
		HelloService spiedService = Mockito.spy(new HelloService());
		Mockito.doNothing().when((HelloService) spiedService).initGreeting();

		assertThat(spiedService.sayGreeting()).isEqualTo("Hello");
		assertThat(spiedService.generalGreeting).isEmpty();
	}

	abstract class GreetingService {

		static final String WELCOME = "Welcome and ";

		String generalGreeting = "";

		public String sayGreeting() {
			initGreeting();
			return getGreeting();
		}

		protected abstract String getGreeting();

		void initGreeting() {
			generalGreeting = WELCOME;
		}
	}

	class HelloService extends GreetingService {

		@Override
		protected String getGreeting() {
			return generalGreeting + "Hello";
		}

	}
}
