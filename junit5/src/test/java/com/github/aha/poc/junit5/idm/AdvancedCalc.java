package com.github.aha.poc.junit5.idm;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public interface AdvancedCalc extends SimpleCalc {
	
	Integer multiply();
	
    @Test
    default void calculateMultiply() {
    	initValues(2, 4);
    	Integer result = multiply();
		assertThat(result, is(equalTo(8)));
    }	

}