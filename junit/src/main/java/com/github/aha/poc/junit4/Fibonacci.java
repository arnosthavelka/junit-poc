package com.github.aha.poc.junit4;

import java.util.ArrayList;
import java.util.Collection;

public class Fibonacci {

    public static Collection<Integer> generate(int size) {
        int firstArg = 0;
        int lastArg = 1;
        Collection<Integer> values = new ArrayList<>();

        for (int i = 0; i < size; i++) {
        	int result = firstArg + lastArg;
			values.add(result);
        	firstArg = lastArg;
        	lastArg = result;
		}

        return values;
    }

    public static int[] compute(int number) {
    	
        int[] result = new int[2];
        result[0] = 0;
        result[1] = 1;
        
    	if (number <= 1) {
    		return result;
    	}

    	do {
        	int backup = result[0] + result[1];  
            result[0] = result[1];
            result[1] = backup;
		} while ((result[0] + result[1]) != number);
        
        return result;
    }
}
