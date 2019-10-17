package com.github.aha.poc.junit5.advanced;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

// based on https://dzone.com/articles/best-java-unit-testing-frameworks
// based on https://www.baeldung.com/guide-to-jayway-jsonpath
@DisplayName("Examples of asserting JSON content with JSONPath")
public class JSONPathTests {

	String jsonContent = "{\n" +
			"  \"_embedded\": {\n" +
			"    \"countries\": [\n" +
			"      {\n" +
			"        \"name\": \"Great Britain\",\n" +
			"        \"currency\": \"GDP\",\n" +
			"        \"cities\": [\"London\", \"Glasgow\", \"Brigton\", \"Manchester\"],\n" +
			"      },\n" +
			"      {\n" +
			"        \"name\": \"Germany\",\n" +
			"        \"currency\": \"EUR\",\n" +
			"        \"cities\": [\"Berlin\", \"Munich\", \"Hamburk\"],\n" +
			"      },\n" +
			"      {\n" +
			"        \"name\": \"Czech Republic\",\n" +
			"        \"currency\": \"CZK\",\n" +
			"        \"cities\": [\"Prague\", \"Brno\", \"Plzen\", \"Ostrava\"],\n" +
			"      },\n" +
			"      {\n" +
			"        \"name\": \"France\",\n" +
			"        \"currency\": \"EUR\",\n" +
			"        \"cities\": [\"Paris\", \"Toulouse\", \"Nice\", \"Marseille\"],\n" +
			"      }\n" +
			"     ]\n" +
			"  },\n" +
			"  \"page\": {\n" +
			"    \"size\": 4,\n" +
			"    \"totalElements\": 4,\n" +
			"    \"totalPages\": 1,\n" +
			"    \"number\": 0\n" +
			"  }\n" +
			"}";

	@Test
	@DisplayName("should check length")
	void lengthCheck() throws JSONException {
		DocumentContext jsonContext = JsonPath.parse(jsonContent);

		assertThat(jsonContext.<Integer>read("$._embedded.countries.length()")).isEqualTo(4);
	}

	@Test
	@DisplayName("should get specific node")
	void getSpecificNode() throws JSONException {
		DocumentContext jsonContext = JsonPath.parse(jsonContent);

		assertThat(jsonContext.<String>read("$._embedded.countries[3].cities[0]")).isEqualTo("Paris");
		JSONArray data = jsonContext.read("$._embedded.countries[?(@.name == \"France\")].cities[0]");
		assertThat(data.get(0)).isEqualTo("Paris");
	}

}
