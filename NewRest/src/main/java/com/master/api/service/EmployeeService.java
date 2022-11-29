package com.master.api.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.master.api.entity.Employee;

public interface EmployeeService {

	void changesEmpDetails(Employee emp, Long id);

	List<Employee> getEmployees();

	Employee getEmployeeById(Long id);

//	void getEmployeeByAdhar(BigDecimal adhar);
//
//	void getEmployeeByDate(LocalDate date);

	void savePost(Employee emp);

	void deleteEmployee(Long id);

	Employee getEmployeeDetails(Long id);

}
