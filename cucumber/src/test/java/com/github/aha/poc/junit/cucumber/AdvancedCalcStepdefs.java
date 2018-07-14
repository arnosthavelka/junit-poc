package com.github.aha.poc.junit.cucumber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import com.github.aha.poc.junit.cucumber.AdvancedCalculator.Operation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AdvancedCalcStepdefs {

	private AdvancedCalculator calc;

	@Given("initialize calculator")
	public void init() {
		calc = new AdvancedCalculator();
	}

	@When("use {int} with {word} operation")
	public void addSingleValue(Integer value, String operationValue) {
		Operation operation = Operation.valueOf(operationValue);
		calc.calculate(operation, value);
	}

	@When("do these math operations")
	public void addMultipleValue(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		for (List<String> item : data) {
			calc.calculate(Operation.valueOf(item.get(0)), Integer.valueOf(item.get(1)));
		}
	}

	@Then("the result value is {int}")
	public void test(Integer finalValue) {
		assertThat(calc.getResult(), is(equalTo(finalValue)));
	}

}
