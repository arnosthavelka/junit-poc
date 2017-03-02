package com.github.aha.poc.junit5.extendwith.stat;

public class StatDTO {
	
	private String name;
	
	private long startTime;
	
	private long endTime;

	public StatDTO(String name) {
		super();
		this.name = name;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}
	
	public long getDuration() {
		return endTime - startTime;
	}	
}
