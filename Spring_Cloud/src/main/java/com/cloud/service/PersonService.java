package com.cloud.service;

import java.util.List;

import com.cloud.domain.Person;

public interface PersonService {

	public List<Person> findAll();
	public Person findOne(String id);
	public Person save(Person p);
	public void delete(String id);
	public List<Person> findByLastName(String lastName);
	public List<Person> findByAgeGreaterThan(int age);
}
