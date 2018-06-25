package com.github.aha.poc.junit.cucumber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.github.aha.poc.junit.cucumber.AdvancedCalculator.Operation;

import cucumber.api.java8.En;

public class AdvancedCalcStepdefs implements En {

	private AdvancedCalculator calc;

	public AdvancedCalcStepdefs() {

		Given("initialize calculator", () -> {
			calc = new AdvancedCalculator();
		});

		When("use {int} with {word} operation", (Integer value, String operationValue) -> {
			Operation operation = Operation.valueOf(operationValue);
			calc.calculate(operation, value);
		});

		Then("the result value is {int}", (Integer finalValue) -> {
			assertThat(calc.getResult(), is(equalTo(finalValue)));
		});

	}

}
