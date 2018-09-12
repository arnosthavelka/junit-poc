package com.github.aha.poc.junit.springboot;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

	Optional<City> findByName(String name);

}
