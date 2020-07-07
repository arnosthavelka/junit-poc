package com.github.aha.poc.junit.cucumber;

import static com.github.aha.poc.junit.cucumber.AdvancedCalculator.Operation.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.github.aha.poc.junit.cucumber.AdvancedCalculator.Operation;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdvancedCalcStepdefs {

	private AdvancedCalculator calc;

	@ParameterType(name = "Operation", value = "[a-zA-Z]+")
	public Operation parseOperation(String value) {
		return valueOf(value);
	}

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
		assertThat(calc.getResult()).isEqualTo(finalValue);
	}

}
