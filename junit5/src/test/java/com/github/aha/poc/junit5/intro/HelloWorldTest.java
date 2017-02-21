package com.github.aha.poc.junit5.intro;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class HelloWorldTest {

	@Test
	void helloWorld(TestInfo testInfo) {
		System.out.println("Hello world!");
	}

}
