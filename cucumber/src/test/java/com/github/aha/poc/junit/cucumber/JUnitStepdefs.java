package com.github.aha.poc.junit.cucumber;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;

public class JUnitStepdefs implements En {

	private int value;
	
	@Given("start with value {int}")
	public void init(int initValue) {
		this.value = initValue;
	}

	@When("add value {int}")
	public void add(int addValue) {
		this.value += addValue;
	}

	@Then("should have value {int}")
	public void check(int finalValue) {
		Assert.assertEquals(value, finalValue);
	}
}
