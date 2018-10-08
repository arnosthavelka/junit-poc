package com.github.aha.poc.junit.springboot;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = { @Autowired })
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
