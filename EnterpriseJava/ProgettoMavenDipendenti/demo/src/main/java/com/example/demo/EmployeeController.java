package com.example.demo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDao;

	// Implementing a GET method to get the list of all the employees
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE) //"text/plain")
	public List<Employee> getEmployees() {
		return employeeDao.listAll();
	}
	
	@GetMapping(path= "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable int id) {
		return employeeDao.getEmployee(id);	
	}

	// Create a POST method to add an employee to the list
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

		// Creating an ID of an employee from-à the number of employees
		int id = employeeDao.listAll().size() + 1;
		employee.setId(id);
		employeeDao.addEmployee(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path= "/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeDao.deleteEmployee(id);
	}
	
	
}