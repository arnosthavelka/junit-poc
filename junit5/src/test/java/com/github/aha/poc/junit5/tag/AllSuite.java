package com.github.aha.poc.junit5.tag;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.runner.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@DisplayName("B Suite - run all marked B tests")
@SelectPackages("com.github.aha.poc.junit5.tag")
public class AllSuite {

}
