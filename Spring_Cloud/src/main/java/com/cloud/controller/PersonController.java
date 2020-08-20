package com.cloud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.domain.Person;
import com.cloud.service.PersonCounterService;
import com.cloud.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonCounterService counterService;
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public List<Person> findAll(){
		return personService.findAll();
	}
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") String id) {
		return personService.findOne(id);
	}
	
	@PostMapping
	public Person add(@RequestBody Person p) {
		p = personService.save(p);
		counterService.countNewPersons();
		return p;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		personService.delete(id);
		counterService.countDeletedPersons();
	}
	
	@PutMapping
	public void update(@RequestBody Person p) {
//		Person person = persons.stream().filter(it -> it.getId().equals(p.getId())).findFirst().get();
//		persons.set(persons.indexOf(person), p);
	}
	
	@GetMapping("/lastname/{lastName}")
	public List<Person> findByLastName(@PathVariable("lastName") String lastName){
		return personService.findByLastName(lastName);
	}
	
	@GetMapping("/age/{age}")
	public List<Person> findByAgeGreaterThan(@PathVariable("age") int age){
		return personService.findByAgeGreaterThan(age);
	}
}
