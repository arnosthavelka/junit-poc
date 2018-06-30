package com.github.aha.poc.junit.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

	@Autowired
	CityRepository repo;

	public List<City> getAll() {
		return repo.findAll();
	}

	public Optional<City> getItem(Long id) {
		return repo.findById(id);
	}
	
}
