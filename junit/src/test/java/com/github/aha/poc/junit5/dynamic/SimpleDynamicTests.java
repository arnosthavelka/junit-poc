package com.github.aha.poc.junit5.dynamic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

// based on http://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests
@DisplayName("A usage of simple dynamic test can be")
public class SimpleDynamicTests {

    @TestFactory
    @DisplayName("just definition of desired tests")
    Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(
            dynamicTest("1st dynamic test", () -> assertTrue("1st dynamic test".contains("dynamic"))),
            dynamicTest("2nd dynamic test", () -> assertEquals(3, "2nd dynamic test".split(" ").length))
        );
    }

    @TestFactory
    @DisplayName("or defined based on values as stream")
    Stream<DynamicTest> dynamicTestsFromStream() {
        return Stream.of("A", "B", "C").map(
            str -> dynamicTest("test" + str, () -> assertEquals(5, ("test" + str).length())));
    }
    
    @TestFactory
    @DisplayName("or calculated based on values as stream")
    Stream<DynamicTest> dynamicTestsFromIntStream() {
        // Generates tests for the first 10 even integers.
        return IntStream.iterate(0, n -> n + 2).limit(5).mapToObj(
            n -> dynamicTest("test" + n, () -> assertTrue(n % 2 == 0)));
    }

}
