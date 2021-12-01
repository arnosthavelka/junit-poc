package com.github.aha.poc.junit.cucumber;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SimpleCalcStepdefs {

	private SimpleCalculator calc;
	
	@When("začneme s výchozí hodnotou {int}")
	public void initScenario(Integer initValue) {
		calc = new SimpleCalculator(initValue);
	}

	@When("přidáme hodnotu {int}")
	public void addMultipleValue(Integer value) {
		calc.add(value);
	}

	@Then("výsledný součet je {int}")
	public void test(Integer finalValue) {
		assertThat(calc.sum()).isEqualTo(finalValue);
	}

}
