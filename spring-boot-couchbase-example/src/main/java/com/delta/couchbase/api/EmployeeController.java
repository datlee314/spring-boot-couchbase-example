package com.delta.couchbase.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repository;
	
	@PostMapping("/employee/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		return repository.save(emp);
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id){
		return repository.findById(id);
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable Integer id,@RequestBody Employee emp) {
		Optional<Employee> employee = repository.findById(id);
		if(employee.isPresent())
			return repository.save(emp);
		else
			return null;
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		repository.deleteById(id);
		return "Document Deleted";
	}
}
