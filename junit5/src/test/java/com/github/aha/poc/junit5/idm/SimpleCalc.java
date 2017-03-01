package com.github.aha.poc.junit5.idm;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public interface SimpleCalc extends Calc<Integer> {
	
	Integer sum();
	
    @Test
    default void calculateSum() {
    	initValues(3, 5);
    	Integer result = sum();
		assertThat(result, is(equalTo(8)));    	
    }	

}