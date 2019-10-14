package com.github.aha.poc.junit5.advanced;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

// based on https://dzone.com/articles/best-java-unit-testing-frameworks
// based on https://www.baeldung.com/guide-to-jayway-jsonpath
@DisplayName("Examples of asserting JSON content with JSONPath")
public class JSONPathTests {

	@Test
	@DisplayName("should check the content in lenient mode")
	void lenientCheck() throws JSONException {
		var jsonContent = "[London, Paris, Prague]";

		DocumentContext jsonContext = JsonPath.parse(jsonContent);

		assertThat(jsonContext.<Integer>read("$.length()")).isEqualTo(3);
		assertThat(jsonContext.<String>read("$[1]")).isEqualTo("Paris");
	}

}
