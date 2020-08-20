package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.domain.Person;
import com.cloud.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository repository;

	@Override
	public List<Person> findByLastName(String lastName) {
		return repository.findByLastName(lastName);
	}

	@Override
	public List<Person> findByAgeGreaterThan(int age) {
		return repository.findByAgeGreaterThan(age);
	}

	@Override
	public List<Person> findAll() {
		return repository.findAll();
	}

	@Override
	public Person findOne(String id) {
		return repository.findById(id).get();
	}

	@Override
	public Person save(Person p) {
		return repository.save(p);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
	}

}
