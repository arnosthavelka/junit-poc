package com.github.aha.poc.junit.cucumber;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;

public class CalcAddStepdefs implements En {

	private Calculator calc;
	
	@Given("start sum operation with value {int}")
	public void init(int initValue) {
		calc = new Calculator(initValue);
	}

	@When("add value {int}")
	public void add(int addValue) {
		calc.add(addValue);
	}

	@Then("the result of sum operation is {int}")
	public void check(int finalValue) {
		Assert.assertEquals(calc.sum(), finalValue);
	}
}
