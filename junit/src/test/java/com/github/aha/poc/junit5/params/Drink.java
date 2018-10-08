package com.github.aha.poc.junit5.params;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Drink {

	@NonNull
	private String name;

	@NonNull
	private Integer price;

}
