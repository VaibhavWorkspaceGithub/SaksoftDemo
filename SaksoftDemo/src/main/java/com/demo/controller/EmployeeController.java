package com.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	

	//to insert single data
	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee employee) {

		employeeService.postEmployee(employee);

		return "Save operation completed";
	}

	// method for fetching one entry using id
	@GetMapping("/getEmployeedata/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		Employee emp2 = employeeService.getEmployeeById(id);

		return ResponseEntity.ok().body(emp2);

	}

	// method for delete operation by id
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployeeById(@PathVariable Integer id) {

		employeeService.deleteEmployee(id);

		return "Employee deleted successfully...";

	}

	// To update the record
	@PutMapping("/update")
	public Employee updateEmployee(Employee employee) {

		return employeeService.updateEmployee(employee);

	}

}
