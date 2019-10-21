package com.github.aha.poc.junit5.advanced;

import static com.jayway.jsonpath.JsonPath.parse;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.Filter;
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

	DocumentContext jsonContext = parse(jsonContent);

	@Test
	@DisplayName("should get value with dot notation")
	void useGetValueWithDotNotation() throws JSONException {
		assertThat(jsonContext.<String>read("$._embedded.countries[3].cities[0]")).isEqualTo("Paris");
	}

	@Test
	@DisplayName("should get value with bracket notation")
	void useGetValueWithBracketNotation() throws JSONException {
		assertThat(jsonContext.<String>read("$['_embedded']['countries'][1]['cities'][0]")).isEqualTo("Berlin");
	}

	@Test
	@DisplayName("should read integer value directly")
	void directRead() throws JSONException {
		Integer jsonPath = JsonPath.read(jsonContent, "$.page.size");

		assertThat(jsonPath).isEqualTo(4);
	}

	@Test
	@DisplayName("should check length")
	void checkLength() throws JSONException {
		assertThat(jsonContext.<Integer>read("$._embedded.countries.length()")).isEqualTo(4);
	}

	@Test
	@DisplayName("should get specific node by country name")
	void getSpecificValueByName() throws JSONException {
		JSONArray data = jsonContext.read("$._embedded.countries[?(@.name == \"France\")].cities[0]");
		assertThat(data.get(0)).isEqualTo("Paris");
	}

	@Test
	@DisplayName("should count all cities")
	void countAllCities() throws JSONException {
		JSONArray data = jsonContext.read("$..cities");
		assertThat(data.stream().map(JSONArray.class::cast).flatMap(x -> x.stream()).count()).isEqualTo(15);
	}

	@Test
	@DisplayName("should filter all countries with EUR currency")
	void filterCities() throws JSONException {
		Filter eurFilter = Filter.filter(Criteria.where("currency").eq("EUR"));
		List<Map<String, String>> countries = jsonContext.read("$['_embedded']['countries'][?]", eurFilter);

		assertThat(countries.size()).isEqualTo(2);
		assertThat(countries.get(0).values().iterator().next()).isEqualTo("Germany");
	}

}
