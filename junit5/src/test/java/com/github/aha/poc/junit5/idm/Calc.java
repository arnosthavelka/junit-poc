package com.github.aha.poc.junit5.idm;

public interface Calc<T> {
	
	void initValues(T val, T val2);
	
}
