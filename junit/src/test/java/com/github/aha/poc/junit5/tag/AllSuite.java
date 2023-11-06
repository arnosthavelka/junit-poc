package com.github.aha.poc.junit5.tag;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@DisplayName("B Suite - run all marked B tests")
@SelectPackages("com.github.aha.poc.junit5.tag")
public class AllSuite {

}
