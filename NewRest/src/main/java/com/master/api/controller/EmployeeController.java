package com.master.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.master.api.entity.Employee;
import com.master.api.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/employee")
	public ResponseEntity<Employee> savePost(@RequestBody Employee emp){		
		this.service.savePost(emp);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<?> updateEmp(@RequestBody Employee emp,@PathVariable Long id){
		this.service.changesEmpDetails(emp,id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> employees = this.service.getEmployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee emp=this.service.getEmployeeById(id);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@GetMapping("/employee/personaldetails/{id}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable Long id){
		Employee emp=this.service.getEmployeeDetails(id);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
//	@GetMapping("/employee/{adhar}")
//	public ResponseEntity<Employee> getEmployeeByAdhar(@PathVariable BigDecimal adhar){
//		this.service.getEmployeeByAdhar(adhar);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	
//	@GetMapping("/employee/{Date}")
//	public ResponseEntity<List<Employee>> getEmployeeByDate(@PathVariable LocalDate Date){
//		this.service.getEmployeeByDate(Date);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	@PatchMapping("/employee/{id}")
	public ResponseEntity<Employee>patchEmployee(@PathVariable Long id, @RequestBody Employee emp){
	Employee empl=this.service.patchEmployee(id);
	 // Employee empl=this.service.saveEmp(emp);
	empl.setFirstName(emp.getFirstName());
	empl.setLastName(emp.getLastName());
	//empl.setGender(emp.getGender());
	Employee emp1=service.savePost(empl);
	
	return new ResponseEntity<Employee>(emp1,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?>deleteEmployee(@PathVariable Long id) {
		this.service.deleteEmployee(id);
		return new ResponseEntity<>(Map.of("Messgae","User Deleted sucessfully"), HttpStatus.OK);
	}
}
