package com.cloud.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cloud.domain.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>{

	public List<Person> findByLastName(String lastName);
	public List<Person> findByAgeGreaterThan(int age);
}
