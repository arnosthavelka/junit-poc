package com.github.aha.poc.junit5.idm;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public interface AdvancedCalc extends SimpleCalc {
	
	Integer multiply();
	
    @Test
    default void calculateMultiply() {
    	setValues(2, 4, 6);
    	Integer result = multiply();
		assertThat(result, is(equalTo(48)));
    }

}