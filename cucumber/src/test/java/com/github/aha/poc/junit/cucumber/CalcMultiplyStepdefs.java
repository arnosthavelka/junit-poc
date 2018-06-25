package com.github.aha.poc.junit.cucumber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import cucumber.api.java8.En;

public class CalcMultiplyStepdefs implements En {

	private Calculator calc;

	public CalcMultiplyStepdefs() {

		Given("start multiply operation with value {int}", (Integer initValue) -> {
			calc = new Calculator(initValue);
		});

		When("multiply by {int}", (Integer addValue) -> {
			calc.add(addValue);
		});

		Then("the result of multiply operation is {int}", (Integer finalValue) -> {
			assertThat(calc.multiply(), is(equalTo(finalValue)));
		});

	}

}
