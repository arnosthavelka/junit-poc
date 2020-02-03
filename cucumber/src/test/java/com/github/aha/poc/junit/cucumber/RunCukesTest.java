package com.github.aha.poc.junit.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"classpath:com/github/aha/poc/junit/cucumber/CalcSimple.feature",
		"classpath:com/github/aha/poc/junit/cucumber/CalcAdvanced.feature" })
public class RunCukesTest {

}
