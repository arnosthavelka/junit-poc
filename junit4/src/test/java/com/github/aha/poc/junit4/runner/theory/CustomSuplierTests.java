package com.github.aha.poc.junit4.runner.theory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.junit.Assume.assumeThat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// https://github.com/junit-team/junit4/wiki/Theories

@RunWith(Theories.class)
public class CustomSuplierTests {
	
	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(CustomSuplierTests.class);	

	@Retention(RetentionPolicy.RUNTIME)
	@ParametersSuppliedBy(PrimeNumberSupplier.class)
	public @interface PrimeNumber {
		
		int start();
		
	    int count();
	}
	
	public static class PrimeNumberSupplier extends ParameterSupplier {

		@Override
		public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
			PrimeNumber annotation = (PrimeNumber) sig.getAnnotation(PrimeNumber.class);

			List<PotentialAssignment> list = new ArrayList<>();
			int nextValue = annotation.start();
			// check the first possible value
			nextValue = nextValue < 3 ? 3 : nextValue - 1;
			int count = annotation.count();
			// generate desired number of prime values
			while (count > 0) {
				nextValue++;
				if (!isPrime(nextValue)) {
					LOG.debug("Skipped number {}", nextValue);
					continue;
				}
				LOG.info("Adding prime number {}", nextValue);
				list.add(PotentialAssignment.forValue("ints", nextValue));
				count--;
			}
			return list;
		}
		
	    /**
	     * Checks to see if the requested value is prime.
	     * @see http://stackoverflow.com/questions/24006143/generating-a-random-prime-number-in-java
	     */
	    public static boolean isPrime(int inputNum){
	        if (inputNum <= 3 || inputNum % 2 == 0) 
	            return inputNum == 2 || inputNum == 3; //this returns false if number is <=1 & true if number = 2 or 3
	        int divisor = 3;
	        while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0)) 
	            divisor += 2; //iterates through all possible divisors
	        return inputNum % divisor != 0; //returns true/false
	    }		
	}	

	private static final int START_NO = 5;
	/**
	 * Prove theory: "all numbers are even" 
	 */
    @Theory
	public void checkPrimeNumbers(@PrimeNumber(start = START_NO, count = 10) int number) {
    	assumeThat(number, not(0));
    	LOG.info("Checking prime number {} ", number);
    	assertThat(number, is(greaterThanOrEqualTo(START_NO)));
    	assertThat(PrimeNumberSupplier.isPrime(number), is(equalTo(true)));
	}

}
