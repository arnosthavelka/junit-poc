package com.github.aha.poc.junit.cucumber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import cucumber.api.java8.Cs;

public class SimpleCalcStepdefs implements Cs {

	private SimpleCalculator calc;
	
	public SimpleCalcStepdefs() {

		Pokud("začneme s výchozí hodnotou {int}", (Integer initValue) -> {
			calc = new SimpleCalculator(initValue);
		});

		Když("přidáme hodnotu {int}", (Integer value) -> {
			calc.add(value);
		});

		Pak("výsledný součet je {int}", (finalValue) -> {
			assertThat(calc.sum(), is(equalTo(finalValue)));
		});

	}

}
