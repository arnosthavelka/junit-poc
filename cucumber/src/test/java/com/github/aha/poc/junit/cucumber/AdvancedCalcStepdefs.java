package com.github.aha.poc.junit.cucumber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import com.github.aha.poc.junit.cucumber.AdvancedCalculator.Operation;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdvancedCalcStepdefs {

	private AdvancedCalculator calc;

	@Given("initialize calculator")
	public void initFeature() {
		calc = new AdvancedCalculator();
	}

	@Before
	public void initScenario(Scenario scenario) {
		log.debug("Starting scenario '{}'", scenario.getName());
	}

	@AfterStep("@advanced")
	public void finishStep(Scenario scenario) {
		log.debug("subtotal={}", calc.getResult());
	}

	@After("@advanced")
	public void finishScenario(Scenario scenario) {
		log.debug("total={}", calc.getResult());
	}

	@When("use {int} with {Operation} operation")
	public void addSingleValue(Integer value, Operation operation) {
		calc.calculate(operation, value);
	}

	@When("do these math operations")
	public void addMultipleValue(List<List<String>> data) {
		data.stream().forEach(item -> calc.calculate(Operation.valueOf(item.get(0)), Integer.valueOf(item.get(1))));
	}

	@Then("the result value is {int}")
	public void test(Integer finalValue) {
		assertThat(calc.getResult(), is(equalTo(finalValue)));
	}

}
