package com.github.aha.poc.junit.springboot;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityService {

	@NonNull
	CityRepository repo;

	public List<City> getAll() {
		return repo.findAll();
	}

	public City getItem(Long id) {
		return repo.findById(id).orElseThrow(EntityNotFoundException::new);
	}

}
