package com.github.aha.poc.junit5.advanced;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.skyscreamer.jsonassert.JSONAssert.assertNotEquals;
import static org.skyscreamer.jsonassert.JSONCompareMode.LENIENT;
import static org.skyscreamer.jsonassert.JSONCompareMode.STRICT;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.RegularExpressionValueMatcher;
import org.skyscreamer.jsonassert.comparator.ArraySizeComparator;
import org.skyscreamer.jsonassert.comparator.CustomComparator;

// based on https://dzone.com/articles/best-java-unit-testing-frameworks
// based on https://www.baeldung.com/jsonassert
@DisplayName("Examples of asserting JSON content")
public class JSONAssertTests {

	@Test
	@DisplayName("should check the content in strict mode")
	void strictCheck() throws JSONException {
		var jsonContent = "{developers:[{\"id\":111,\"name\":\"Arnost Havelka\",\"company\":\"Deutsche Boerse\"},"
				+ "{\"id\":222,\"name\":\"Josh Long\",\"company\":\"Pivotal\"}]}";

		assertEquals("{developers:[{\"id\":111,\"name\":\"Arnost Havelka\",\"company\":\"Deutsche Boerse\"},"
				+ "{\"id\":222,\"name\":\"Josh Long\",\"company\":\"Pivotal\"}]}", jsonContent, true);
		assertEquals("{developers:[{id:111,name:\"Arnost Havelka\",company:\"Deutsche Boerse\"},"
				+ "{id:222,name:\"Josh Long\",company:\"Pivotal\"}]}", jsonContent, true);
		assertNotEquals("{developers:[{name:\"Arnost Havelka\"},{name:\"Josh Long\"}]}", jsonContent, true);
	}

	@Test
	@DisplayName("should check the content in lenient mode")
	void lenientCheck() throws JSONException {
		var jsonContent = "[London, Paris, Prague]";
		assertEquals("[London, Paris, Prague]", jsonContent, STRICT);
		assertNotEquals("[London, Madrid, Prague, Paris]", jsonContent, LENIENT);
		assertNotEquals("[London, Prague]", jsonContent, LENIENT);
		assertEquals("[London, Prague, Paris]", jsonContent, LENIENT);
	}

	@Test
	@DisplayName("should check array size")
	void arraySizeCheck() throws JSONException {
		var jsonContent = "{values:[1, 3, 5, 7]}";
		assertEquals("{values:[4]}", jsonContent, new ArraySizeComparator(LENIENT));
	}

	@Test
	@DisplayName("should check range of values in array")
	void arrayRangeCheck() throws JSONException {
		var jsonContent = "{values:[1, 3, 5, 7]}";
		assertEquals("{values:[1, 10]}", jsonContent, new ArraySizeComparator(LENIENT));
	}

	@Test
	@DisplayName("should check values with regular expression")
	void regexpCheck() throws JSONException {
		assertEquals("{entry:{id:value}}", "{entry:{id:1, id:2}}", new CustomComparator(JSONCompareMode.STRICT,
				new Customization("entry.id", new RegularExpressionValueMatcher<Object>("\\d"))));
		assertEquals("{entry:{currency:value}}", "{entry:{currency:CZK, currency:EUR, currency: USD}}",
				new CustomComparator(JSONCompareMode.STRICT,
						new Customization("entry.currency", new RegularExpressionValueMatcher<Object>("[A-Z]{3}"))));
	}

}
