package com.github.aha.poc.junit.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:com/github/aha/poc/junit/cucumber/JUnit.feature")
public class JUnitCukesTest {

}
