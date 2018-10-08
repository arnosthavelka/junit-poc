package com.github.aha.poc.junit5.extension.extendwith.stat;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StatDTO {

	@NonNull
	private String name;

	private long startTime = System.currentTimeMillis();

}
