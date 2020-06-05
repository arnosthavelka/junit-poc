package com.github.aha.poc.junit.cucumber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SimpleCalcStepdefs /* implements Cs */ {

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
		assertThat(calc.sum(), is(equalTo(finalValue)));
	}

//	public SimpleCalcStepdefs() {
//
//		Pokud("začneme s výchozí hodnotou {int}", (Integer initValue) -> {
//			calc = new SimpleCalculator(initValue);
//		});
//
//		Když("přidáme hodnotu {int}", (Integer value) -> {
//			calc.add(value);
//		});
//
//		Pak("výsledný součet je {int}", (finalValue) -> {
//			assertThat(calc.sum(), is(equalTo(finalValue)));
//		});
//
//	}
//
}
