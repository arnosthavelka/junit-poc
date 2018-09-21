package com.github.aha.poc.junit5.params;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Examples of aggregator usage in parameterized tests")
public class AggregatorParamTests {

	@ParameterizedTest
	@DisplayName("Usage of ArgumentsAccessor")
	@CsvSource({ "Rum, 70", "Whiskey, 50", "'Gin Fizz', 150" })
	void simpleAccessor(ArgumentsAccessor arguments) {
		assertThat(arguments.size()).isEqualTo(2);
		assertThat(arguments.getString(0)).isNotNull();
		assertThat(arguments.getInteger(1)).isNotNull();
	}

	@ParameterizedTest
	@DisplayName("Usage of custom aggregator")
	@CsvSource({ "Rum, 70", "Whiskey, 50", "'Gin Fizz', 150" })
	void customAccessor(@AggregateWith(DrinkAggregator.class) Drink drink) {
		assertThat(drink.getName()).isNotNull();
		assertThat(drink.getPrice()).isNotNull();
	}

	@ParameterizedTest
	@DisplayName("Usage of custom aggregator with annotation")
	@CsvSource({ "Rum, 70", "Whiskey, 50", "'Gin Fizz', 150" })
	void customAggregatorWithAnnotation(@CsvToDrink Drink drink) {
		assertThat(drink.getName()).isNotNull();
		assertThat(drink.getPrice()).isNotNull();
	}
}
