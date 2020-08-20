package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;

@Service
public class PersonCounterServiceImpl implements PersonCounterService{
	
	private final MeterRegistry registry;
	
	@Autowired
	public PersonCounterServiceImpl(MeterRegistry registry) {
		this.registry = registry;
		this.registry.counter("services.person.add", Tags.empty());
		this.registry.counter("services.person.delete", Tags.empty());
	}

	@Override
	public void countNewPersons() {
		System.out.println("ddd");
		registry.counter("services.person.add", Tags.empty()).increment();
	}
	
	@Override
	public void countDeletedPersons() {
		registry.counter("services.person.delete", Tags.empty()).increment();
	}
	
}
