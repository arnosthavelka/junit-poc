package com.github.aha.poc.junit5.idm;

public class CalcTests implements AdvancedCalc {

	private Integer val1;
	
	private Integer val2;
	
	@Override
	public void initValues(Integer val1, Integer val2) {
		this.val1 = val1;
		this.val2 = val2;
	}

	@Override
	public Integer sum() {
		return val1 + val2;
	}

	@Override
	public Integer multiply() {
		return val1 * val2;
	}

}
