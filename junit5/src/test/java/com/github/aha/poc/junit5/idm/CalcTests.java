package com.github.aha.poc.junit5.idm;

import java.util.Arrays;

public class CalcTests implements AdvancedCalc {

	private Integer[] values;
	
	@Override
	public void setValues(Integer... values) {
		this.values = values;
	}

	@Override
	public Integer sum() {
		return Arrays.asList(values).stream().reduce(0, Integer::sum);
	}

	@Override
	public Integer multiply() {
		return values.length == 0 ? 0 : Arrays.stream(values).reduce(1, (a1, a2) -> a1 * a2);
	}

}
