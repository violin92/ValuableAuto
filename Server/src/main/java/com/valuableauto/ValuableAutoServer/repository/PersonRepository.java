package com.valuableauto.ValuableAutoServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valuableauto.ValuableAutoServer.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	public Person findByUsername(String username);
}
