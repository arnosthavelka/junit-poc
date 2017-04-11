package com.github.aha.poc.junit4.extension.validation;

import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runners.Suite.SuiteClasses;

import com.github.aha.poc.junit4.extension.runner.category.annotation.CalculatorOperation;
import com.github.aha.poc.junit4.extension.runner.suite.test.AddTests;
import com.github.aha.poc.junit4.extension.runner.suite.test.MultiplyTests;

@IncludeCategory(CalculatorOperation.class)
//@ExcludeCategory(NoInput.class)
@SuiteClasses({
	AddTests.class,
	MultiplyTests.class
})
public class ValidationTests extends AbstractValidationTest {

}
