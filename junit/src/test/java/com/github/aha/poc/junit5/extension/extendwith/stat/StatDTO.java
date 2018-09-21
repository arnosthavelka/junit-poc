package com.github.aha.poc.junit5.extension.extendwith.stat;

public class StatDTO {
	
	private String name;
	
	private long startTime;
	
	public StatDTO(String name) {
		this.name = name;
		this.startTime = System.currentTimeMillis();
	}

	public String getName() {
		return name;
	}

	public long getStartTime() {
		return startTime;
	}

}
