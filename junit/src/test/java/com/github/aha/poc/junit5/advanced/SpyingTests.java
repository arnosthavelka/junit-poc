package com.github.aha.poc.junit5.advanced;

import static com.github.aha.poc.junit5.advanced.SpyingTests.Greeting.GreetingService.WELCOME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import lombok.Getter;

// based on https://blog.jdriven.com/2013/05/mock-superclass-method-with-mockito/
@DisplayName("Examples of spying tests")
public class SpyingTests {

	@Nested
	@DisplayName("simple inheritance")
	class Greeting {

		@Test
		@DisplayName("should use service in standard way")
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

	@Nested
	@DisplayName("inheritance with generics")
	class Calculator {

		@Test
		@DisplayName("should use service in standard way")
		void regularUsage() {
			assertThat(new IntCalc().add(3)).isEqualTo(8);
		}

		@Test
		@DisplayName("should mock inherited method in spied class")
		void mockInheritedMethod() {
			IntCalc spiedService = Mockito.spy(new IntCalc());
			given(spiedService.add(anyInt())).willReturn(0);

			assertThat(spiedService.add(3)).isEqualTo(0);
			reset(spiedService);
			assertThat(spiedService.add(5)).isEqualTo(10);
		}

		abstract class AbstractCalc<V extends Number> {

			@Getter
			V value = getInitValue();

			public V add(V valueToBeAdded) {
				return addValue(value, valueToBeAdded);
			}

			abstract V getInitValue();

			abstract V addValue(V currentValue, V valueToBeAdded);

		}

		class IntCalc extends AbstractCalc<Integer> {

			@Override
			protected Integer addValue(Integer currentValue, Integer addition) {
				return currentValue + addition;
			}

			@Override
			Integer getInitValue() {
				return 5;
			}

		}

	}

}
