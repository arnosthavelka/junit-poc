package com.github.aha.poc.junit4.cathegory;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.github.aha.poc.junit4.cathegory.annotation.CalculatorOperation;
import com.github.aha.poc.junit4.cathegory.annotation.NoInput;
import com.github.aha.poc.junit4.suite.test.AddTests;
import com.github.aha.poc.junit4.suite.test.MultiplyTests;

// https://examples.javacodegeeks.com/core-java/junit/junit-suite-test-example/

@RunWith(Categories.class)
@IncludeCategory(CalculatorOperation.class)
@ExcludeCategory(NoInput.class)
@SuiteClasses({
	AddTests.class,
	MultiplyTests.class
})
public class CalcWithInputTests {

}
