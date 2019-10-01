package com.github.aha.poc.junit5;

import static com.github.aha.poc.junit5.SpyingTests.Greeting.GreetingService.WELCOME;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import lombok.Getter;

// based on https://blog.jdriven.com/2013/05/mock-superclass-method-with-mockito/
@DisplayName("Examples of spying tests")
public class SpyingTests {

	@Nested
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
	class Calculator {

		@Test
		@DisplayName("should use service in standard way")
		void regularUsage() {
			IntCalc service = new IntCalc();

			assertThat(service.add(5)).isEqualTo(5);
			assertThat(service.add(3)).isEqualTo(8);
			assertThat(service.add(4)).isEqualTo(0);
		}

		@Test
		@DisplayName("should mock inherited method in spied class")
		void mockInheritedMethod() {
			IntCalc spiedService = Mockito.spy(new IntCalc());
			Mockito.doNothing().when((IntCalc) spiedService).initValue();

			assertThat(spiedService.add(5)).isEqualTo(5);
			assertThat(spiedService.add(3)).isEqualTo(8);
			assertThat(spiedService.add(4)).isEqualTo(12);
		}

		abstract class AbstractCalc<V extends Number> {

			@Getter
			V value;

			int count = 0;

			{
				initValue();
			}

			public V add(V addition) {
				value = addValue(value, addition);
				checkCount();
				return value;
			}

			abstract void initValue();

			abstract V addValue(V value2, V addition);

			private void checkCount() {
				count++;
				if (count % 3 == 0) {
					initValue();
				}
			}

		}

		class IntCalc extends AbstractCalc<Integer> {

			@Override
			protected Integer addValue(Integer currentValue, Integer addition) {
				return currentValue + addition;
			}

			@Override
			void initValue() {
				value = 0;
			}

		}

	}

}
