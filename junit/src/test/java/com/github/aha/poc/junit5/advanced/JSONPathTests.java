package com.github.aha.poc.junit5.advanced;

import static com.jayway.jsonpath.JsonPath.parse;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

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
class JSONPathTests {

	String jsonContent = """
			{
			  "_embedded": {
			    "countries": [
			      {
			        "name": "Great Britain",
			        "currency": "GDP",
			        "cities": ["London", "Glasgow", "Brigton", "Manchester"],
			      },
			      {
			        "name": "Germany",
			        "currency": "EUR",
			        "cities": ["Berlin", "Munich", "Hamburk"],
			      },
			      {
			        "name": "Czech Republic",
			        "currency": "CZK",
			        "cities": ["Prague", "Brno", "Plzen", "Ostrava"],
			      },
			      {
			        "name": "France",
			        "currency": "EUR",
			        "cities": ["Paris", "Toulouse", "Nice", "Marseille"],
			      }
			     ]
			  },
			  "page": {
			    "size": 4,
			    "totalElements": 4,
			    "totalPages": 1,
			    "number": 0
			  }
			}""";

	DocumentContext jsonContext = parse(jsonContent);

	@Test
	@DisplayName("should calculate max function")
	void maxFunction() {
		Double maxValue = JsonPath.read("{values:[1, 3, 9, 7]}", "$.values.max()");

		assertThat(maxValue).isEqualTo(9);
	}

	@Test
	@DisplayName("should get value with dot notation")
	void useGetValueWithDotNotation() {
		assertThat(jsonContext.<String>read("$._embedded.countries[3].cities[0]")).isEqualTo("Paris");
	}

	@Test
	@DisplayName("should get value with bracket notation")
	void useGetValueWithBracketNotation() {
		assertThat(jsonContext.<String>read("$['_embedded']['countries'][1]['cities'][0]")).isEqualTo("Berlin");
	}

	@Test
	@DisplayName("should read integer value directly")
	void directRead() {
		Integer jsonPath = JsonPath.read(jsonContent, "$.page.size");

		assertThat(jsonPath).isEqualTo(4);
	}

	@Test
	@DisplayName("should check length")
	void checkLength() {
		assertThat(jsonContext.<Integer>read("$._embedded.countries.length()")).isEqualTo(4);
	}

	@Test
	@DisplayName("should get specific node by country name")
	void getSpecificValueByName() {
		JSONArray data = jsonContext.read("$._embedded.countries[?(@.name == \"France\")].cities[0]");
		assertThat(data.get(0)).isEqualTo("Paris");
	}

	@Test
	@DisplayName("should count all cities")
	void countAllCities() {
		JSONArray data = jsonContext.read("$..cities");
		assertThat(data.stream().map(JSONArray.class::cast).flatMap(x -> x.stream()).count()).isEqualTo(15);
	}

	@Test
	@DisplayName("should filter all countries with EUR currency")
	void filterCities() {
		Filter eurFilter = Filter.filter(Criteria.where("currency").eq("EUR"));
		List<Map<String, String>> countries = jsonContext.read("$['_embedded']['countries'][?]", eurFilter);

		assertThat(countries)
			.hasSize(2)
			.flatExtracting(Map::values)
			.first()
			.isEqualTo("Germany");
	}

}
