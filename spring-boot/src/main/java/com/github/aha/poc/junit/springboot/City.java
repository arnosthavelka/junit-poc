package com.github.aha.poc.junit.springboot;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "CITY")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class City {

	@Id
	@Column(name = "ID")
	@NonNull
	protected Long id;

	@Column(name = "NAME")
	@NonNull
	private String name;

	@Column(name = "COUNTRY")
	private String country;

}
